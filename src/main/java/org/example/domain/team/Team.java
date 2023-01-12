package org.example.domain.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.user.User;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Team {

    private Integer tid;
    private String name;
    private String invite_link;
    private LocalDateTime create_link_date;

    //Setter가 없는 상호아에서의 DB 삽입 방법
    //기본적으로는 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것
    //값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 함
    //@Builder를 통해 제공되는 빌더 클래스 사용
    public Team update(String newLink){
        this.invite_link = newLink;
        return this;
    }

}
