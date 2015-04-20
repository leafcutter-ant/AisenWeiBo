package org.aisen.weibo.sina.base;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.m.common.context.GlobalContext;
import com.m.common.utils.ActivityHelper;
import com.m.common.utils.SystemUtils;

import org.aisen.weibo.sina.R;

/**
 * Created by wangdan on 15/4/12.
 */
public class AppSettings {

    static final int[] countArr = { 20, 50, 100 };

    public static final int REQUEST_DATA_DELAY = 500;

    public static int getPublishDelay() {
        return 5 * 1000;
    }

    /**
     * 网络请求延迟
     *
     * @return
     */
    public static boolean isNetworkDelay() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pNetworkDelay", false);
    }

    /**
     * 提醒设置
     *
     * @return
     */
    public static boolean isNotifyEnable() {
        return ActivityHelper.getBooleanShareData("org.aisen.weibo.sina.NOTIFICATION", true);
    }

    /**
     * 提及评论提醒
     *
     * @return
     */
    public static boolean isNotifyCommentMention() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pCommentMention", true);
    }

    /**
     * 提及微博提醒
     *
     * @return
     */
    public static boolean isNotifyStatusMention() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pStatusMention", true);
    }

    /**
     * 粉丝提醒
     *
     * @return
     */
    public static boolean isNotifyFollower() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pFollower", true);
    }

    /**
     * 评论提醒
     *
     * @return
     */
    public static boolean isNotifyComment() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pComment", true);
    }

    /**
     * 私信提醒
     *
     * @return
     */
    public static boolean isNotifyDm() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pDm", true);
    }

    /**
     * 声音提醒
     *
     * @return
     */
    public static boolean isNotifySound() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pNotifySound", true);
    }

    /**
     * 振动提醒
     *
     * @return
     */
    public static boolean isNotifyVibrate() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pNotifyVibrate", true);
    }

    /**
     * LED提醒
     *
     * @return
     */
    public static boolean isNotifyLED() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pNotifyLED", true);
    }

    /**
     * 夜间不扰
     *
     * @return
     */
    public static boolean isNotifyNightClose() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pNightClose", true);
    }

    /**
     * 发送成功后的震动反馈
     *
     * @return
     */
    public static boolean isSendVibrate() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pSendVibrate", true);
    }

    /**
     * 未读小时间隔时间
     *
     * @return
     */
    public static int getUnreadInterval() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        int value = Integer.parseInt(prefs.getString("pInterval", "0"));
        String[] valueArr = GlobalContext.getInstance().getResources().getStringArray(R.array.prefValues);

        int interval = 60;

        switch (Integer.parseInt(valueArr[value])) {
            case 0:
                interval = 60;
                break;
            case 1:
                interval = 60 * 5;
                break;
            case 2:
                interval = 60 * 15;
                break;
            case 3:
                interval = 60 * 60;
                break;
        }

        return interval;
    }

    /**
     * 上传图片质量设置
     *
     * @return
     */
    public static int getUploadSetting() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        int value = Integer.parseInt(prefs.getString("pUploadSetting", "0"));
        return value;
    }

    /**
     * 应用常驻内存
     *
     * @return
     */
    public static boolean isAppResident() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pAppResident", true);
    }

    /**
     * 微博加载数量
     *
     * @return
     */
    public static int getTimelineCount() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        int index = Integer.parseInt(prefs.getString("pTimelineCount", "3"));

        int count = countArr[0];
        if (index == 3) {
            if (SystemUtils.getNetworkType() == SystemUtils.NetWorkType.wifi)
                count = 100;
        }
        else {
            count = countArr[index];
        }

        return count;
    }

    /**
     * 图片加载模式
     *
     * @return
     */
    public static int getPictureMode() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        int value = Integer.parseInt(prefs.getString("pPicMode", "2"));
        return value;
    }

    /**
     * 默认加载原图
     *
     * @return
     */
    public static boolean isLoadOrigPic() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pLoadOrigPic", false);
    }

    /**
     * 是否使用内置浏览器
     *
     * @return
     */
    public static boolean isInnerBrower() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pInnerBrowser", true);
    }

    /**
     * 正文字体大小
     *
     * @return
     */
    private static int[] txtSizeResArr = new int[]{ R.dimen.sp_12, R.dimen.sp_13, R.dimen.sp_14, R.dimen.sp_15,
            R.dimen.sp_16, R.dimen.sp_17, R.dimen.sp_18, R.dimen.sp_19,
            R.dimen.sp_20 };
    public static int getTextSize() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        int value = Integer.parseInt(prefs.getString("pTextSize", "4"));
        return GlobalContext.getInstance().getResources().getDimensionPixelSize(txtSizeResArr[value]);
    }

    /**
     * 无图模式
     *
     * @return
     */
    public static boolean isPicNone() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pNonePic", false);
    }

    /**
     * 是否显示备注
     *
     * @return
     */
    public static boolean isShowRemark() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pShowRemark", true);
    }

    /**
     * 显示高清头像
     *
     * @return
     */
    public static boolean isLargePhoto() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GlobalContext.getInstance());
        return prefs.getBoolean("pLargePhoto", true);
    }

}