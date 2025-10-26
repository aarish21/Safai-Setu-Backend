package com.aarish.safai_setu.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aarish.safai_setu.model.Report;
import com.aarish.safai_setu.service.ReportService;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class ReportController {
	@Autowired
	private ReportService service;
	
	@GetMapping("/report")
	public ResponseEntity<List<Report>> getAllReport() {
		return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
	}
	
	@PostMapping("/report")
	public ResponseEntity<?> addReport(@RequestPart Report report, @RequestPart MultipartFile imageFile) {
		try {
			Report addNewReport = service.addReport(report, imageFile);
			return new ResponseEntity<>(addNewReport,HttpStatus.CREATED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/report/{id}")
    public ResponseEntity<Report> getReport(@PathVariable int id) {
        Report report = service.getReport(id);
        if (report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	@GetMapping("/report/{reportId}/image")
	public ResponseEntity<byte[]> getImageByReportId(@PathVariable int reportId) {
	    Report reportImage = service.getReport(reportId);
	    byte[] imageFile = reportImage.getImageData();

	    return ResponseEntity.ok()
	            .contentType(MediaType.valueOf(reportImage.getImageType())) // use imageType
	            .body(imageFile);
	}
	
	 @DeleteMapping("/report/{id}")
	 public ResponseEntity<String> deleteReport(@PathVariable int id) {
	        Report report = service.getReport(id);
	        if (report != null) {
	            service.deleteProduct(id);
	            return new ResponseEntity<>("Deleted", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	        }

	 }
	 @PutMapping("/report/{id}/resolve")
	 public ResponseEntity<Report> markReportResolved(
	         @PathVariable int id,
	         @RequestPart("image") MultipartFile imageFile) {

	     try {
	         Report updated = service.markResolved(id, imageFile);
	         if (updated != null)
	             return new ResponseEntity<>(updated, HttpStatus.OK);
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     } catch (IOException e) {
	         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	     }
	 }

	 

}
