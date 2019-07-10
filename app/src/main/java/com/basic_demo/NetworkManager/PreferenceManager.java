package com.basic_demo.NetworkManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.basic_demo.common.Const;

/**
 * Created by asif on 20-02-2018.
 */

public class PreferenceManager {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public PreferenceManager(Context context) {
        if (context != null) {
            preferences = context.getSharedPreferences(Const.SHARED_PREF, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public void clearAllPrefData() {
        editor.clear().apply();
        setWalkthroughStatus(true);
    }


    public void setWalkthroughStatus(boolean status) {
        editor.putBoolean(Const.Pref.WALKTHROUGH_STATUS, status).apply();
    }

    public boolean getWalkthroughStatus() {
        return preferences.getBoolean(Const.Pref.WALKTHROUGH_STATUS, false);
    }


    public void setTempUserData(String userData) {
        if (preferences.contains(Const.Pref.TEMP_DATA)) {
            editor.remove(Const.Pref.TEMP_DATA).apply();
        }
        editor.putString(Const.Pref.TEMP_DATA, userData);
        editor.apply();
    }

    public String getTempUserData() {
        return preferences.getString(Const.Pref.TEMP_DATA, "");
    }

    public void setUserData(String userData) {
        if (preferences.contains(Const.Pref.USER_DATA)) {
            editor.remove(Const.Pref.USER_DATA).apply();
        }
        editor.putString(Const.Pref.USER_DATA, userData);
        editor.commit();
    }

    public String getUserData() {
        return preferences.getString(Const.Pref.USER_DATA, "");
    }

    public void setPushData(String pushData) {
        editor.putString(Const.Pref.PUSH_DATA, pushData);
        editor.commit();
    }

    public String getPushData() {
        return preferences.getString(Const.Pref.PUSH_DATA, "");
    }

    public void clearPushData(){
        if (preferences.contains(Const.Pref.PUSH_DATA)) {
            editor.remove(Const.Pref.PUSH_DATA).apply();
        }
    }

    public void setCountryCode(String code) {
        editor.putString(Const.Pref.COUNTRY_CODE, code);
        editor.commit();
    }

    public String getCountryCode() {
        return preferences.getString(Const.Pref.COUNTRY_CODE, "");
    }


    public void setHomeData(String data) {
//        if (preferences.contains(Const.Pref.HOME_DATA)) {
//            editor.remove(Const.Pref.HOME_DATA).apply();
//        }
        editor.putString(Const.Pref.HOME_DATA, data);
        editor.commit();
    }

    public String getHomeData() {
        return preferences.getString(Const.Pref.HOME_DATA, "");
    }

    public void setSocialFeedData(String source, String data) {
//        if (preferences.contains(Const.Pref.SOCIAL_FEED_DATA)) {
//            editor.remove(Const.Pref.SOCIAL_FEED_DATA).apply();
//        }
        editor.putString(Const.Pref.SOCIAL_FEED_DATA+"-"+source, data);
        editor.commit();
    }

    public String getSocialFeedData(String source) {
        return preferences.getString(Const.Pref.SOCIAL_FEED_DATA+"-"+source, "");
    }

    public void clearSocialFeedData(String source) {
        editor.remove(Const.Pref.SOCIAL_FEED_DATA+"-"+source).commit();
    }

    public void setStoreData(String data) {
        editor.putString(Const.Pref.STORE_DATA, data);
        editor.commit();
    }

    public String getStoreData() {
        return preferences.getString(Const.Pref.STORE_DATA, "");
    }


    public void setStoreDetailsData(String id, String data) {
        editor.putString(Const.Pref.STORE_DETAILS_DATA+"-"+id, data);
        editor.commit();
    }

    public void clearStoreDetailsData(String id) {
        editor.remove(Const.Pref.STORE_DETAILS_DATA+"-"+id).commit();
    }

    public String getStoreDetailsData(String id) {
        return preferences.getString(Const.Pref.STORE_DETAILS_DATA+"-"+id, "");
    }


    public void setLoginType(String type){
        editor.putString(Const.Pref.LOGIN_TYPE, type);
        editor.commit();
    }

    public String getLoginType() {
        return preferences.getString(Const.Pref.LOGIN_TYPE, "");
    }

    public void setNewsFeedData(String data) {
        editor.putString(Const.Pref.NEWS_FEED_DATA, data);
        editor.commit();
    }


    public String getNewsFeedData() {
        return preferences.getString(Const.Pref.NEWS_FEED_DATA, "");
    }

    public void clearNewsFeedData() {
        editor.remove(Const.Pref.NEWS_FEED_DATA).commit();
    }

    public void setLiveScheduleData(String data) {
        editor.putString(Const.Pref.LIVE_SCHEDULE_DATA, data);
    }

    public void setDownloadListData(String data) {
        editor.putString(Const.Pref.DOWNLOAD_LIST_DATA, data);
        editor.commit();
    }


    public String getLiveScheduleData() {
        return preferences.getString(Const.Pref.LIVE_SCHEDULE_DATA, "");
    }


    public String getDownloadListData() {
        return preferences.getString(Const.Pref.DOWNLOAD_LIST_DATA, "");
    }

    public String getChallengeMainData() {
        return preferences.getString(Const.Pref.CHALLENGE_DATA, "");
    }

    public void setChallengeMainData(String data) {
        editor.putString(Const.Pref.CHALLENGE_DATA, data);
        editor.commit();
    }

    public String getOnGoingChallengeMainData() {
        return preferences.getString(Const.Pref.ONGOING_CHALLENGE_DATA, "");
    }

    public void setOnGoingChallengeMainData(String data) {
        editor.putString(Const.Pref.ONGOING_CHALLENGE_DATA, data);
        editor.commit();
    }

    public String getChallengeViratUserData() {
        return preferences.getString(Const.Pref.CHALLENGE_DATA, "");
    }

    public void setChallengeViratUserData(String data) {
        editor.putString(Const.Pref.CHALLENGE_DATA, data);
        editor.commit();
    }

    public String getChallengeUserInnerData() {
        return preferences.getString(Const.Pref.CHALLENGE_USER_INNER_DATA, "");
    }

    public void setLiveCountDownData(String data) {
        editor.putString(Const.Pref.LIVE_COUNT_DOWN_DATA, data);
        editor.commit();
    }

    public String getLiveCountDownData() {
        return preferences.getString(Const.Pref.LIVE_COUNT_DOWN_DATA, "");
    }

    public void setChallengeUserInnerData(String data) {
        editor.putString(Const.Pref.CHALLENGE_USER_INNER_DATA, data);
        editor.commit();
    }


    public void setGalleryFeedData(String data) {
        editor.putString(Const.Pref.GALLERY_FEED_DATA, data);
        editor.commit();
    }

    public String getGalleryFeedData() {
        return preferences.getString(Const.Pref.GALLERY_FEED_DATA, "");
    }


    public void setTokenData(String userData) {
        if (preferences.contains(Const.Pref.TOKEN_DATA)) {
            editor.remove(Const.Pref.TOKEN_DATA).apply();
        }
        editor.putString(Const.Pref.TOKEN_DATA, userData);
        editor.apply();
    }

    public String getTokenData() {
        return preferences.getString(Const.Pref.TOKEN_DATA, "");
    }

}
