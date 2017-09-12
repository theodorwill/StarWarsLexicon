package starwars.app.starwarsse.resources;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by cba on 2017-09-12.
 */

public class CustomTextView extends TextView{

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/StarCustom.ttf"));
    }
}
