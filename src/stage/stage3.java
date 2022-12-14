package stage;

import java.awt.Color;
import java.io.IOException;
import java.util.*;
import arkanoid_object.*;
import event.ball_smallEvent;
import event.bar_longEvent;
import event.bar_speedupEvent;
import event.character_hpup;
import event.speed_upEvent;

public class stage3 extends Stage {

	public stage3(character ch, ball b) throws IOException {
		super();
		stage_num = 3;
		// 5 15 25 마다 턴 전환
		// 11 왼쪽 끝 좌표 오른쪽 끝 좌표552 끝 좌표
		int turn = 1;
		int save1 = -23;
		int save2 = 573;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 2; j++) {
				bricks.add(2 * i + j, new brick());
				if ((i == 11 || i == 21) && j == 0) {
					turn *= -1;
				}
				if (j % 2 == 0) {
					save1 += 50 * turn;
					bricks.get(2 * i + j).setX(save1);
				} else {
					save2 -= 50 * turn;
					bricks.get(2 * i + j).setX(save2);
				}
				bricks.get(2 * i + j).setY(11 + 20 * i);
				bricks.get(2 * i + j).setCollision(b);
				bricks_th.add(2 * i + j, new Thread(bricks.get(2 * i + j).th));
				bricks.get(2 * i + j).getPan().setSize(bricks.get(2 * i + j).getSize_x(), bricks.get(2 * i + j).getSize_y());
				bricks.get(2 * i + j).getPan().setLocation(bricks.get(2 * i + j).getX(), bricks.get(2 * i + j).getY());
				if ((2 * i + j )% 4 == 0)
					bricks.get(2 * i + j).setBrick_image("images\\Block\\Block_sky.png");
				else if ((2 * i + j )% 4 == 1)
					bricks.get(2 * i + j).setBrick_image("images\\Block\\Block_white.png");
				else if ((2 * i + j )% 4 == 2)
					bricks.get(2 * i + j).setBrick_image("images\\Block\\Block_navy.png");
				else
					bricks.get(2 * i + j).setBrick_image("images\\Block\\Block_blue.png");
				
				if(bricks.get(2 * i + j).getX()==-23+50*6) {
						if(bricks.get(2 * i + j).getY()==11 + 20 * 5)
							bricks.get(2 * i + j).setItem(new speed_upEvent(ch,bricks.get(2 * i + j), b));
						else
							bricks.get(2 * i + j).setItem(new bar_longEvent(ch,bricks.get(2 * i + j), b));
							
				}
					if(bricks.get(2 * i + j).getX()==573-50*10&&bricks.get(2 * i + j).getY()==11 + 20 * 9)
						bricks.get(2 * i + j).setItem(new character_hpup(ch,bricks.get(2 * i + j), b));
					else if(bricks.get(2 * i + j).getX()==-23+50*2&&bricks.get(2 * i + j).getY()==11 + 20 * 21)
						bricks.get(2 * i + j).setItem(new bar_speedupEvent(ch,bricks.get(2 * i + j), b));
						
			
				if(bricks.get(2 * i + j).getX()==373&&bricks.get(2 * i + j).getY()==351)
						bricks.get(2 * i + j).setItem(new bar_speedupEvent(ch,bricks.get(2 * i + j), b));
				if((bricks.get(2 * i + j).getX()==523&&bricks.get(2 * i + j).getY()==411)||
					(bricks.get(2 * i + j).getX()==373&&bricks.get(2 * i + j).getY()==471))
					bricks.get(2 * i + j).setItem(new speed_upEvent(ch,bricks.get(2 * i + j), b));
			}
		}
	}

	@Override
	public String getH_wall() {
		return "images\\ice\\ice_pillar_cols.png";
	}

	@Override
	public String getW_wall() {
		return "images\\ice\\ice_pillar_rows.png";
	}

	@Override
	public String getball_image() {
		return "images\\ice\\ice_ball.png";
	}

	@Override
	public String getBackground_image() {
		return "images\\ice\\ice_back.png";
	}

	@Override
	public String getStage_Music() {
		return "sounds\\background_music\\ice.mp3";
		
	}
}
