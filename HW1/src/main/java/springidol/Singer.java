package springidol;

public class Singer implements Performer{

    //Singer 는 Performer 의 일종으로, 이름과 지정곡 정보를 갖는다.
    //지정곡은 위에서 정의한 Song 클래스의 객체를 참조한다.
    private Song song; // 참조니까 Song 타입
    private String name;
    //또한 노래를 부르면서 guitar 나 piano 등 악기를 연주하는 것도 가능하도록 한다.
    private Instrument instrument; //악기도 참조

    //Singer 는 Constructor 를 이용해서 DI가 실행될 수 있도록 정의한다.
    public Singer(Song song, String name, Instrument instrument){
        this.song=song;
        this.name=name;
        this.instrument=instrument;
    }
    //악기 없을때!
    public Singer(Song song, String name){
        this.song=song;
        this.name=name;
    }

    // xml에서 가수 A의 song을 받아오려고 (#{lena.song}) getter 추가했어요.
    public Song getSong() {
        return song;
    }


    //가수는 공연할 때 이름과 지정된 곡에 관한 정보(제목, 원곡자)를 출력한다.
    @Override
    public void perform() throws PerformanceException{
        System.out.println(name + " is singing " + song.getTitle() + " by " + song.getArtist());
        //가수가 악기를 함께 연주할 경우 악기 이름(=클래스명)과 연주 결과(소리)도 출력한다.
        if (instrument!=null){
            System.out.println("while playing "+ instrument.toString() );
            instrument.play();
        }
    }
}
