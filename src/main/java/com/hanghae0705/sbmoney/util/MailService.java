package com.hanghae0705.sbmoney.util;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    // spring-boot를 사용하면 JavaMailSender Bean을 생성할 필요 없이 자동으로 생성됨
    // 그렇기 때문에 properties에 smtp 설정만 하면 된다
    // 고 하는데 나는 안 되길래 JavaMailSenderImpl 에 Bean을 생성해주었다

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String email, String accessToken, String username) {
        //ArrayList<String> toUserList = new ArrayList<>();
        //toUserList.add(email);
        //int toUserSize = toUserList.size();

        // 단순 텍스트 구성 메시지 발송
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 수신자 설정
        simpleMailMessage.setTo(email);

        // 메일 제목
        simpleMailMessage.setSubject("[티끌] 비밀번호 변경 메일입니다.");

        // 메일 내용
        simpleMailMessage.setText("비밀번호 변경 링크입니다. 3분 이내에 접속하여 비밀번호를 변경해 주세요. : "
                + "https://www.tikkeeul.com/changePassword?accessToken="
                + accessToken
                + "&username="
                + username);

        // 메일 발송
        javaMailSender.send(simpleMailMessage);
    }


}
