package jp.co.desertfox.calculator;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		// button
		Button btnPlus = (Button) findViewById(R.id.buttonPlus);
		btnPlus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TextView text = (TextView) findViewById(R.id.textOpe);
				text.setText("+");
			}
		});
		Button btnMinus = (Button) findViewById(R.id.buttonMinus);
		btnMinus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TextView text = (TextView) findViewById(R.id.textOpe);
				text.setText("-");
			}
		});
		Button btnTimes = (Button) findViewById(R.id.buttonTimes);
		btnTimes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TextView text = (TextView) findViewById(R.id.textOpe);
				text.setText("×");
			}
		});
		Button btnDevide = (Button) findViewById(R.id.buttonDevide);
		btnDevide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TextView text = (TextView) findViewById(R.id.textOpe);
				text.setText("÷");
			}
		});

		Button btnOk = (Button) findViewById(R.id.buttonOk);
		btnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TextView textLeft1 = (TextView) findViewById(R.id.textLeft1);
				TextView textLeft2 = (TextView) findViewById(R.id.textLeft2);
				TextView textOpe = (TextView) findViewById(R.id.textOpe);
				TextView textRight = (TextView) findViewById(R.id.textRight);
				TextView textScore = (TextView) findViewById(R.id.textScore);
				ImageView imgResult = (ImageView) findViewById(R.id.imageResult);
				Integer score = Integer
						.parseInt(textScore.getText().toString());
				if (calc(textLeft1.getText(), textLeft2.getText(),
						textRight.getText(), textOpe.getText())) {
					score += 10;
					imgResult.setImageResource(R.drawable.correct);
				} else {
					score -= 10;
					imgResult.setImageResource(R.drawable.incorrect);
				}
				textScore.setText(score.toString());
				setInitial();
			}
		});
		return true;
	}

	public void setInitial() {
		TextView textLeft1 = (TextView) findViewById(R.id.textLeft1);
		TextView textLeft2 = (TextView) findViewById(R.id.textLeft2);
		TextView textOpe = (TextView) findViewById(R.id.textOpe);
		TextView textRight = (TextView) findViewById(R.id.textRight);

		Random rnd = new Random();
		Integer left1 = rnd.nextInt(99) + 1;
		Integer left2 = rnd.nextInt(99) + 1;
		Integer right = getRight(left1, left2);
		textLeft1.setText(left1.toString());
		textLeft2.setText(left2.toString());
		textRight.setText(right.toString());
		textOpe.setText("?");

	}

	public int getRight(int left1, int left2) {
		int right = 0;
		Random rnd = new Random();
		boolean decidedOpe = false;
		while (!decidedOpe) {
			int ope = rnd.nextInt(3);
			switch (ope) {
			case 0:
				right = left1 + left2;
				decidedOpe = true;
				break;
			case 1:
				right = left1 - left2;
				decidedOpe = true;
				break;
			case 2:
				right = left1 * left2;
				decidedOpe = true;
				break;
			case 3:
				if (left1 % left2 == 0) {
					right = left1 / left2;
					decidedOpe = true;
				}
				break;
			}
		}
		return right;
	}

	public boolean calc(CharSequence left1, CharSequence left2,
			CharSequence right, CharSequence ope) {
		int left1int = Integer.parseInt(left1.toString());
		int left2int = Integer.parseInt(left2.toString());
		int rightint = Integer.parseInt(right.toString());
		return calc(left1int, left2int, rightint, ope);
	}

	public boolean calc(int left1, int left2, int right, CharSequence ope) {
		int left;
		if (ope.equals("+")) {
			left = left1 + left2;
		} else if (ope.equals("-")) {
			left = left1 - left2;
		} else if (ope.equals("×")) {
			left = left1 * left2;
		} else if (ope.equals("÷")) {
			left = left1 / left2;
		} else {
			return false;
		}

		return left == right;
	}
}
