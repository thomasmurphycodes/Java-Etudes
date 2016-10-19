public class EnumDemo{
	String title;
	String artist;
	Media media;

	public EnumDemo(String artist, String title, Media media){
		this.artist = artist;
		this.title = title;
		this.media = media;
	}

	@Override
	public String toString() {
		switch(media) {
			case BOOK:
				return title + " is a book";
			case MUSIC_CD:
				return title + " is a cd by " + artist;
			case MUSIC_VINYL:
				return title + " is a vinyl record by " + artist;
			case MOVIE_DVD:
				return title + " is a dvd";
		}
	}
}