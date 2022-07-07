package com.hanghae0705.sbmoney.service;

import com.hanghae0705.sbmoney.data.Message;
import com.hanghae0705.sbmoney.exception.Constants;
import com.hanghae0705.sbmoney.exception.ItemException;
import com.hanghae0705.sbmoney.model.domain.Category;
import com.hanghae0705.sbmoney.model.domain.Item;
import com.hanghae0705.sbmoney.repository.CategoryRepository;
import com.hanghae0705.sbmoney.repository.ItemRepository;
import com.hanghae0705.sbmoney.validator.ItemValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemValidator itemValidator;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    public Message postItem(Item.Request itemRequest) throws ItemException {
        itemValidator.isExistItem(itemRequest.getItemName());
        Category category = categoryRepository.findById(itemRequest.getCategoryId()).orElseThrow(
                () -> new ItemException(Constants.ExceptionClass.CATEGORY, HttpStatus.BAD_REQUEST, "존재하지 않는 카테고리입니다.")
        );
        Item item = new Item(itemRequest, category);
        itemRepository.save(item);
        return new Message(true, "아이템 추가를 성공했습니다.", item);
    }

    public Message getItems() {
        List<Item> items = itemRepository.findAll();
        List<Item.Response> itemResponses = new ArrayList<>();
        for(Item item : items){
            if(item.getId() != -1L || item.getCategory().getId() != -1L){
                Item.Response itemResponse = new Item.Response(item);
                itemResponses.add(itemResponse);
            }

        }
        return new Message(true, "아이템 전체 조회를 성공했습니다.", itemResponses);
    }
}