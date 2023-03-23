package vo;

import java.sql.Date;

public class MusicVO {
	private int music_no;
	private String music_name;
	private String singer;
	private Date release_date;

	public MusicVO() {
	}

	public MusicVO(int music_no, String music_name, String singer, Date release_date) {
		this.music_no = music_no;
		this.music_name = music_name;
		this.singer = singer;
		this.release_date = release_date;
	}

	public int getMusic_no() {
		return music_no;
	}

	public void setMusic_no(int music_no) {
		this.music_no = music_no;
	}

	public String getMusic_name() {
		return music_name;
	}

	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return "[" + singer + "] " + music_name + " (" + release_date + ")";
	}

}
