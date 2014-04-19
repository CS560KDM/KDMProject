/**
 * The pauseButton
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 */

package com.quchen.flappycow;

import edu.umkc.project.R;

public class PauseButton extends Sprite{
	public PauseButton(GameView view, Game game) {
		super(view, game);
		this.bitmap = createBitmap(game.getResources().getDrawable(R.drawable.pause_button));
		this.width = this.bitmap.getWidth();
		this.height = this.bitmap.getHeight();
	}
	
	/**
	 * Sets the button in the right upper corner.
	 */
	@Override
	public void move(){
		this.x = this.view.getWidth() - this.width;
		this.y = 0;
	}
}