package com.aarish.safai_setu.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aarish.safai_setu.model.Report;
import com.aarish.safai_setu.repo.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository repo;

	public Report addReport(Report report, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub
		report.setImageName(imageFile.getOriginalFilename());
		report.setImageType(imageFile.getContentType());
		report.setImageData(imageFile.getBytes());
		return repo.save(report);
	}
	

	public List<Report> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	public Report getReport(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}


	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	public Report markResolved(int id, Report reportDetails, MultipartFile imageFile) throws IOException {
	    Optional<Report> optionalReport = repo.findById(id);
	    if (!optionalReport.isPresent()) {
	        return null;
	    }

	    Report report = optionalReport.get();

	    // Save resolved image
	    report.setResolvedImageName(imageFile.getOriginalFilename());
	    report.setResolvedImageType(imageFile.getContentType());
	    report.setResolvedImageData(imageFile.getBytes());

	    // Update status
	    report.setStatus("Pending Verification");

	    return repo.save(report);
	}


}
