/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Account;
import entity.Image;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yuche
 */
public class ImageDAL extends GenericDAL<Image> {
    public ImageDAL(){
        super(Image.class);
    }
    public List<Image> findAll(){
        return findResults( "Image.findAll", null);
    }
    
    public Image findById(int id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult( "Image.findById", map);
    }
    
    public List<Image> findByBoardid(int boardid){
        Map<String, Object> map = new HashMap<>();
        map.put("boardid", boardid);
        return findResults( "Image.findByBoardid", map);
    }
    
    public List<Image> findByTitle(String title){
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        return findResults( "Image.findByTitle", map);
    }
    
    public Image findByUrl(String url){
        Map<String, Object> map = new HashMap<>();
        map.put("url", url);
        return findResult( "Image.findByUrl", map);
    }
    
    public List<Image> findByDate(Date date){
        Map<String, Object> map = new HashMap<>();
        map.put("date", date);
        return findResults( "Image.findByDate", map);
    }
    public Image findByLocalPath(String localPath){
         Map<String, Object> map = new HashMap<>();
        map.put("localPath", localPath);
        return findResult( "Image.findByLocalPath", map);
    }
}
