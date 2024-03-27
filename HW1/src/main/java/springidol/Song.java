package springidol;

public class Song {

    //Song 은 제목(title)과 원곡자(artist) 이름을 속성(property)으로 갖는다.
    private String title;
    private String artist;
    //Song 은 Setter 를 이용해서 의존객체/값들을 주입받고,
    public void setTitle(String title){
        this.title=title;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }

}
