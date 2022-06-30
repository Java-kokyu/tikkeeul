package com.hanghae0705.sbmoney.repository;

import com.hanghae0705.sbmoney.model.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoard_Id(Long boardId);
}
