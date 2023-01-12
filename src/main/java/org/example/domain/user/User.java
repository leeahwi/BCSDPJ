package org.example.domain.user;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User{

    //키 값
    private Integer uid;
    private String name;
    private String email;

    private String userId; //회원 id
    private String userPw; //회원 pw

    //private String authority; //회원 권한

    //Setter가 없는 상호아에서의 DB 삽입 방법
    //기본적으로는 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것
    //값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 함
    //@Builder를 통해 제공되는 빌더 클래스 사용
    public User update(String name, String email){
        this.name = name;
        return this;
    }

    public User updatePw(String newPw){
        userPw = newPw;
        return this;
    }
}
