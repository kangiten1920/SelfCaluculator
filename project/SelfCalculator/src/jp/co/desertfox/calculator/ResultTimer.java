package jp.co.desertfox.calculator;

import android.os.CountDownTimer;
import android.widget.ImageView;

public class ResultTimer extends CountDownTimer {

	ImageView imgResult;

	public ResultTimer(long millisInFuture, long countDownInterval,
			ImageView imgResult) {
		super(millisInFuture, countDownInterval);
		this.imgResult = imgResult;
	}

	@Override
	public void onFinish() {
		// カウントダウン完了後に呼ばれる
		imgResult.setImageResource(0);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		// インターバル(countDownInterval)毎に呼ばれる
	}
}