package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;
public class QueueExample {

    //단일 책임의 원칙 위배 switch에서 case문 mail도보내고 sms도보내고 katalk도 보내고 있음
    //ocp 위배 만약 pax를 보낸다하면 case문을 추가하고 제거하고 요구사항이 바뀔때마다 코드수정이 빈번하게 일어남
    //개선은 어떻게 해야할지는 스위치문을 추상화해서 단일 모양으로 구성
    // 이떄 패턴이 있는데 command패턴
    // 문자열하고 행위하고 맵핑 시켜야함 이떄 map을 사용해서 구성함 Map<String, 작업자체>
    // 코어는 여러개인데 실행흐름이 하나만 있는데 multi thread기법으로 성능을 올림
    // pool을 구성해서 진행
    //main은 주로 queue 관리 해서 thread에 일을 분배
    // excute라는 메서드로 아예 구현한다던지 Message에 excute를 직접 구현한다던지

    // 각각의 개별 스레드가 메세지 큐를 보고 있다가 비어있으면 기다리고 있으면 꺼내고 행동하게 구성
    // 이때 동기화 문제가 발생 syncronized 붙여서 해결해야하는데 collection 자체가 동기화가 되어있으면 그냥 사용하면되는데
    // collections의(유틸리티클래스 컬렉션에 대한 유틸리티클래스) syncronizedxxx()메소드 있음
    // 여기에 매개변수로 내가 만든 자료구조를 넣어줌 이러면 동기화된 구조로 리턴해줌
    // 일종의 프록시 느낌이 있음

    public static void main(String[] args) {
//Queue 컬렉션 생성
        Queue<Message> messageQueue = new LinkedList<>();
//메시지 넣기
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));
//메시지를 하나씩 꺼내어 처리
        while(!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            switch(message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS 를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡를 보냅니다.");
                    break;
            }
        }
    }
}