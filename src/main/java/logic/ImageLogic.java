/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import common.ValidationException;
import dal.ImageDAL;
import entity.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.ObjIntConsumer;

/**
 *
 * @author yu chengzhi
 */
public class ImageLogic extends GenericLogic<Image, ImageDAL> {
    public static SimpleDateFormat FORMATTER = new SimpleDateFormat("YYYY-M-DD hh:mm:ss");
    public static String ID = "id";
    public static String URL = "url";
    public static String TITLE = "title";
    public static String DATE = "date";
    public static String LOCAL_PATH = "localPath";
    public static String BOARD_ID = "boardId";                

    ImageLogic(){
        super(new ImageDAL());
    };
    
    @Override
    public List<Image> getAll(){
        return get(() -> dal().findAll());
    }
    @Override
    public Image getWithId (int id){
        return get(() -> dal().findById(id));
    }
    public List<Image> getImagesWithBoardId(int boardID){
        return get(() -> dal().findByBoardid(boardID));
    }
    public List<Image> getImagesWithTitle(String title){
        return get(() -> dal().findByTitle(title));
    }
    public Image getImageWithUrl(String url){
        return get(() -> dal().findByUrl(url));
    }
    public Image getImageWithLocalPath(String path){
        return get(() ->dal().findByLocalPath(LOCAL_PATH));
    }
    public List<Image> getImagesWithDate(Date date){
        return get(() -> dal().findByDate(date));
    }
    public String convertDate(Date date){
        
        return date.toString();
    }
    @Override
    public Image createEntity(Map<String,String[]> parameterMap){
        Objects.requireNonNull(parameterMap, "parameterMap cannot be null");
        
        Image entity = new Image();
        
        if(parameterMap.containsKey(ID)){
            try{
                entity.setId(Integer.parseInt(parameterMap.get(ID)[0]));
            }catch(java.lang.NumberFormatException ex){
                throw new ValidationException(ex);
            }
        }
        
        ObjIntConsumer<String> validator = (value, length) -> {
            if (value == null || value.trim().isEmpty() || value.length() > length){
                throw new ValidationException("value cannot be null, empty or larger than " + length + " characters");
            }            
        };
       String url = parameterMap.get(URL)[0];
       String title = parameterMap.get(TITLE)[0];
       String date = parameterMap.get(DATE)[0];
       String localPath = parameterMap.get(LOCAL_PATH)[0];
       String boardId = parameterMap.get(BOARD_ID)[0];
                
       validator.accept(url, 45);
       validator.accept(title, 45);
       validator.accept(date, 45);
       validator.accept(localPath, 45);
       validator.accept(boardId, 45);
                
       entity.setUrl(url);
       entity.setTitle(title);
       entity.setDate(convertDate(date));
       entity.setLocalPath(localPath);
       //entity.setBoard(boardId);
         
        
       return entity;
    }   
    @Override
    public Image updateEntity(Map<String,String[]> paramterMap){
        return null;
    }
    
    @Override
    public List<String> getColumnNames(){
        return null;
    }
    @Override
    public List<String> getColumnCodes(){
        return null;
    }
    @Override
    public List<?> extractDataAsList(Image e){
        return null;
    }

}


