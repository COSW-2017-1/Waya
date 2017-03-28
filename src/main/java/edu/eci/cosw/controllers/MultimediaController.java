package edu.eci.cosw.controllers;


import edu.eci.cosw.entities.Multimedia;
import edu.eci.cosw.entities.MultimediaId;
import edu.eci.cosw.services.MultimediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.Date;
import java.util.Iterator;
import java.io.InputStream;
import java.util.List;

/**
 * Created by david on 17/03/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/multimedia")
public class MultimediaController {

    @Autowired
    private MultimediaServices multimediaServices;

    public void setMultimediaServices(MultimediaServices multimediaServices) {
        this.multimediaServices = multimediaServices;
    }

    @RequestMapping(path = "/{bar}/{numero}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Blob> getMultimedia(@PathVariable int numero, @PathVariable int bar) {
        MultimediaId a=new MultimediaId(bar,numero);
        Multimedia toReturn = multimediaServices.getById(a);
        if(toReturn == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(toReturn.getMultimedia());

    }

    @RequestMapping(path = "/{bar}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Multimedia>> getAllMultimediaBar(@PathVariable int bar){
        List<Multimedia> toReturn = multimediaServices.getMultimediaByBar(bar);
        if(toReturn == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(toReturn);
    }

    @RequestMapping(
            value = "/{bar}",
            method = RequestMethod.POST
    )
    public ResponseEntity uploadFile(MultipartHttpServletRequest request,@PathVariable int bar) {

        try {
            Iterator<String> itr = request.getFileNames();
            System.out.println(request.toString());

            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                String mimeType = file.getContentType();
                String filename = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                Blob bb= new SerialBlob(bytes);
                System.out.println(mimeType+"--------------------------------------------------------------------------------------------");
                multimediaServices.SaveMultimedia(new Multimedia(new Date(),mimeType,bb,new MultimediaId(bar,10)));
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


    @RequestMapping(path = "/{bar}/{numero}/video", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getVideoFromMultimediaById(@PathVariable int bar, @PathVariable int numero){
        InputStream toReturn = multimediaServices.getContentOfMultimedia(new MultimediaId(bar,numero));
        if(toReturn==null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .body(new InputStreamResource(toReturn));
    }
}