package springidol;

public class Piano implements Instrument{
    public Piano(){

    }
    // 그냥 보기 좋으라고 넣었어요.. 안 그럼 springidol.Piano@36902638 이렇게 반환되데요..
    @Override
    public String toString() {
        return "Piano";
    }

    public void play() {
        System.out.println("PLANK PLANK PLANK~~");
    }
}
