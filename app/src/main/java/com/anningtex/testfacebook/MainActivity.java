package com.anningtex.testfacebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @author Administrator
 * desc:Fresco使用
 * souce: 1. https://www.jianshu.com/p/6b4a7bf17540
 * 2.  https://www.cnblogs.com/RGogoing/p/6208171.html
 * 注:在DraweeView的layout_width和layout_height并不支持wrap_content属性，
 * 一旦使用了这个属性，将会导致view的onLayout()方法重新执行，出现画面的跳跃
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        SimpleDraweeView sdv = findViewById(R.id.sdv);
        sdv.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605169741296&di=38783ddb532dac4fbe4084d88ef9db28&imgtype=0&src=http%3A%2F%2Fpic25.nipic.com%2F20121107%2F8847866_164210379199_2.jpg");

        SimpleDraweeView sdv1 = findViewById(R.id.sdv1);
        sdv1.setImageURI("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605170884808&di=2af9c8502cd7c56b39b3c02791cf86d1&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F81%2F71%2F01300000164151121808718718556.jpg");
        sdv1.setAspectRatio(1.33f);

        SimpleDraweeView sdv2 = findViewById(R.id.sdv2);
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        // 设置淡入淡出效果的显示时间
        GenericDraweeHierarchy hierarchy = builder.setFadeDuration(3000).build();
        DraweeController placeHolderDraweeController = Fresco.newDraweeControllerBuilder()
                .setUri("http://avatar.csdn.net/4/E/8/1_y1scp.jpg")
                //设置在加载失败后,能否重试
                .setTapToRetryEnabled(true)
                .setOldController(sdv2.getController())
                .build();
        sdv2.setController(placeHolderDraweeController);
        sdv2.setHierarchy(hierarchy);
    }
}