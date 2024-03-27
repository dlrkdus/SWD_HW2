package springidol;

public class Encore {
    //Encore 클래스는 앵콜 공연을 할 한 명의 공연자 정보(Performer bean 참조)와
    // 앵콜 공연을 실행하는 execute() 메소드를 갖는다.
    private Performer encoreist;

    public void setEncoreist(Performer perfomer) {
        this.encoreist = perfomer;
    }

    public void execute() {
        System.out.println("<Encore Performance>");
        encoreist.perform();
    }

}
