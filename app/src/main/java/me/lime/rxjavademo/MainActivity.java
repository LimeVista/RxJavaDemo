package me.lime.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.lime.rxjavademo.entity.Mobile;
import me.lime.rxjavademo.entity.Result;
import me.lime.rxjavademo.services.MobileService;
import me.lime.rxjavademo.utils.RetrofitManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.num_edit)
    EditText numEdit;

    @BindView(R.id.display_text)
    TextView displayText;

    private MobileService mService;

    @BindView(R.id.hello_text)
    TextView helloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mService = RetrofitManager.getInst().
                getRetrofit().create(MobileService.class);
    }

    @OnClick(R.id.btn1)
    void onBtnClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                try {
                    btn1Click();
                }catch (Exception e){
                    displayText.setText("输入号码有误或者网络超时！查询失败！");
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void btn1Click(){
        mService.getInfo(numEdit.getText().toString().trim())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result<Mobile>>() {
                    @Override
                    public void accept(@NonNull Result<Mobile> mobileResult) throws Exception {
                        displayText.setText(execText(mobileResult));
                        Log.i(TAG,"操作成功");
                    }
                });
    }

    private String execText(Result<Mobile> result){
        if(result.getStatus()==0)
            return "数据请求失败";
        Mobile mobile = result.getData();
        StringBuffer buffer = new StringBuffer('\n');
        buffer.append("手机号码号段：\t").append(mobile.getPrefix()).append('\n')
                .append("手机号码：\t\t\t").append(mobile.getMobile()).append('\n')
                .append("归属地：\t\t\t\t\t").append(mobile.getProvince())
                .append(' ').append(mobile.getCity()).append('\n')
                .append("运营商：\t\t\t\t\t").append(mobile.getIsp()).append('\n')
                .append("套餐类型：\t\t\t").append(mobile.getTypes());
        return buffer.toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                e.onNext(2);
//            }
//        }).subscribe(new Observer<Integer>() {
//
//            private Disposable mDisposable;
//            @Override
//            public void onSubscribe(@NonNull Disposable disposable) {
//                mDisposable = disposable;
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                helloText.setText("Hello RxJava!");
//                if(integer.equals(2)) {
//                    mDisposable.dispose();
//                    Log.i(TAG,"onNext:"+"退出观察者模式");
//                }
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.i(TAG,"onError:"+e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG,"onComplete:"+"完成操作");
//            }
//        });
    }
}
