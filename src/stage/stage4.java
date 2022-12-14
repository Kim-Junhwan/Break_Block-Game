package stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import arkanoid_object.Music;
import arkanoid_object.ball;
import arkanoid_object.brick;
import arkanoid_object.character;
import event.ball_TransparentEvent;
import event.ball_smallEvent;
import event.bar_longEvent;
import event.bar_speed_downEvent;
import event.bar_speedupEvent;

public class stage4 extends Stage{

	public stage4(character ch, ball b) throws IOException {
		super();
		stage_num = 4;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 3; j++) {
				bricks.add(3*i+j, new brick());
				bricks.get(3*i+j).setX(60 +50 * j);
				bricks.get(3*i+j).setY(180+20*i);
				bricks.get(3*i+j).setCollision(b);
				bricks_th.add(3*i+j, new Thread(bricks.get(3*i+j).th));
				bricks.get(3*i+j).getPan().setSize(bricks.get(3*i+j).getSize_x(), bricks.get(3*i+j).getSize_y());
				bricks.get(3*i+j).getPan().setLocation(bricks.get(3*i+j).getX(), bricks.get(3*i+j).getY());
				bricks.get(3 * i + j).setBrick_image("images\\Block\\Block_red.png");
				if(bricks.get(3 * i + j).getX()==110) {
					if(bricks.get(3 * i + j).getY()==180)
						bricks.get(3 * i + j).setItem(new ball_TransparentEvent(ch,bricks.get(3 * i + j), b));
					if(bricks.get(3 * i + j).getY()==220)
						bricks.get(3 * i + j).setItem(new ball_smallEvent(ch,bricks.get(3 * i + j), b));
					if(bricks.get(3 * i + j).getY()==260)
						bricks.get(3 * i + j).setItem(new bar_speed_downEvent(ch,bricks.get(3 * i + j), b));
				}
			}
			}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				bricks.add(3*i+j+36, new brick());
				bricks.get(3*i+j+36).setX(210 +50 * j);
				bricks.get(3*i+j+36).setY(100+20*i);
				bricks.get(3*i+j+36).setCollision(b);
				bricks_th.add(3*i+j+36, new Thread(bricks.get(3*i+j+36).th));
				bricks.get(3*i+j+36).getPan().setSize(bricks.get(3*i+j+36).getSize_x(), bricks.get(3*i+j+36).getSize_y());
				bricks.get(3*i+j+36).getPan().setLocation(bricks.get(3*i+j+36).getX(), bricks.get(3*i+j+36).getY());
				bricks.get(3 * i + j+36).setBrick_image("images\\Block\\Block_red.png");
				if(bricks.get(3 * i + j+36).getY()<=120) {
					bricks.get(3 * i + j+36).setItem(new bar_longEvent(ch,bricks.get(3 * i + j+36), b));
				}
				if(i==9&&j==1)
					bricks.get(3 * i + j+36).setItem(new ball_TransparentEvent(ch,bricks.get(3 * i + j+36), b));
			}
			}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 3; j++) {
				bricks.add(3*i+j+66, new brick());
				bricks.get(3*i+j+66).setX(360 +50 * j);
				bricks.get(3*i+j+66).setY(180+20*i);
				bricks.get(3*i+j+66).setCollision(b);
				bricks_th.add(3*i+j+66, new Thread(bricks.get(3*i+j+66).th));
				bricks.get(3*i+j+66).getPan().setSize(bricks.get(3*i+j+66).getSize_x(), bricks.get(3*i+j+66).getSize_y());
				bricks.get(3*i+j+66).getPan().setLocation(bricks.get(3*i+j+66).getX(), bricks.get(3*i+j+66).getY());
				bricks.get(3*i+j+66).setBrick_image("images\\Block\\Block_red.png");
				if(i==6&&j==1) {
					bricks.get(3*i+j+66).setItem(new bar_speed_downEvent(ch,bricks.get(3*i+j+66), b));
				}
				if(i==8&&j==0)
					bricks.get(3*i+j+66).setItem(new ball_smallEvent(ch,bricks.get(3*i+j+66), b));
			
			}
			}
		
	}
	@Override
	public String getH_wall() {
		return "images\\Fire\\fire_pillar_cols.png";
	}
	@Override
	public String getW_wall() {
		return "images\\Fire\\fire_pillar_rows.png";
	}
	@Override
	public String getball_image() {
		return "images\\Fire\\fire_ball.png";
	}
	@Override
	public String getBackground_image() {
		return "images\\Fire\\fire_back.png";
	}
	@Override
	public String getStage_Music() {
		return "sounds\\background_music\\fire.mp3";
	}
}
