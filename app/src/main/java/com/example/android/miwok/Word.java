package com.example.android.miwok;

/**
 * Created by Muhammad on 4/10/2018.
 */

public class Word {
    private String mDefaultTrans;
    private String mMiwokTrans;
    private int mImageResourceId= NOIMANGEPROVIDED;
    private static final int NOIMANGEPROVIDED=-1;
    private int mAudioResourceId;

    public Word (String defaultTrans,String miwokTrans,int ImageResourceId,int audioResourceId){
        mDefaultTrans=defaultTrans;
        mMiwokTrans=miwokTrans;
        mImageResourceId=ImageResourceId;
        mAudioResourceId=audioResourceId;
    }
    public Word (String defaultTrans,String miwokTrans,int audioResourceId){
        mDefaultTrans=defaultTrans;
        mMiwokTrans=miwokTrans;
        mAudioResourceId=audioResourceId;
    }
    public String getmDefaultTrans(){

        return mDefaultTrans;
    }
    public String getmMiwokTrans(){

        return mMiwokTrans;
    }
    public int  getmImageResourceId(){

        return mImageResourceId;
    }
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
    public boolean has_image(){
        return mImageResourceId !=NOIMANGEPROVIDED;
    }
}
