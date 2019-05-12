package io.tr.code.audio.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.tr.code.audio.Models.FileModel;
import io.tr.code.audio.Models.MainModel;
import io.tr.code.audio.Models.RadioModel;
import io.tr.code.audio.R;

public class Utils {


    public static final String END_POINT_URL = "https://archive.org";
    private static final String Log = "";


    /**
     * this method to get the random image from the drawable folder
     *
     * @param context
     * @return
     */
    public static Drawable getRandomImage(Context context) {

        Drawable listImages[] = {
                context.getResources().getDrawable(R.drawable.a),
                context.getResources().getDrawable(R.drawable.b),
                context.getResources().getDrawable(R.drawable.c),
                context.getResources().getDrawable(R.drawable.d),
                context.getResources().getDrawable(R.drawable.e),
                context.getResources().getDrawable(R.drawable.f),
                context.getResources().getDrawable(R.drawable.i),
                context.getResources().getDrawable(R.drawable.g),
                context.getResources().getDrawable(R.drawable.j),
                context.getResources().getDrawable(R.drawable.h),
                context.getResources().getDrawable(R.drawable.image_one)
        };

        int size = listImages.length;

        return listImages[(int) (Math.random() * size)];
    }


    /**
     * Read Local Json file
     *
     * @param context
     * @return
     */
    public static String loadJSONFromAsset(Context context,String name) {
        String json = null;
        try {
            InputStream is = context.getApplicationContext().getAssets().open(name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public static  List<MainModel> getListAudio(Context context) {
        List<MainModel> mainModels = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context,"data.json"));
            JSONArray m_jArry = obj.getJSONArray("data");

            for (int i = 0; i < m_jArry.length(); i++) {

                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String identifier = jo_inside.getString("identifier");
                String title = jo_inside.getString("title");
                MainModel mainModel = new MainModel();
                mainModel.setId(identifier);
                mainModel.setTitle(title);
                mainModels.add(mainModel);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mainModels;
    }


    public static ArrayList<FileModel> filterList(ArrayList<FileModel> fileModel){

        ArrayList<FileModel> models=new ArrayList<>();
        for (FileModel item : fileModel ) {
            if (item.getName().endsWith("mp3")){
                models.add(item);
            }
        }

        return models;
    }


    public static List<RadioModel> getListRadio(Context context) {
        List<RadioModel> mainModels = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context,"radio.json"));
            JSONArray m_jArry = obj.getJSONArray("radios");

            for (int i = 0; i < m_jArry.length(); i++) {

                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String name = jo_inside.getString("name");
                String url = jo_inside.getString("radio_url");
                RadioModel radioModel= new RadioModel();
                radioModel.setName(name);
                radioModel.setRadio_url(url);
                mainModels.add(radioModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mainModels;
    }




}
