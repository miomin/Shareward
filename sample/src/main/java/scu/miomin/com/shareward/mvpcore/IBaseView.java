package scu.miomin.com.shareward.mvpcore;

/**
 * Created by miomin on 2016/11/14.
 */
public interface IBaseView {

    /**
     * 显示加载动画
     * @param title 标题
     * @param message 内容
     */
    void showLoading(String title, String message);

    /**
     * 隐藏加载动画
     */
    void hideLoading();

    /**
     * 生成Toast
     * @param message 内容
     */
    void showToast(String message);
}
