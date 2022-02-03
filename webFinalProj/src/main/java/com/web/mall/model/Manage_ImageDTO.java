package com.web.mall.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Manage_ImageDTO {
	private int ImageID;
	private int ReferencesID;
	private String IDType;
	private String FileName;
	private String FileURL;
	private MultipartFile File;
	private List<MultipartFile> Files;//멀티 파일 전송
	
	public int getImageID() {
		return ImageID;
	}
	public void setImageID(int imageID) {
		ImageID = imageID;
	}
	public int getReferencesID() {
		return ReferencesID;
	}
	public void setReferencesID(int referencesID) {
		ReferencesID = referencesID;
	}
	public String getIDType() {
		return IDType;
	}
	public void setIDType(String iDType) {
		IDType = iDType;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileURL() {
		return FileURL;
	}
	public void setFileURL(String fileURL) {
		FileURL = fileURL;
	}
	public String getFullPath() {
		return FileURL + "/" + FileName;
	}
	public MultipartFile getFile() {
		return File;
	}
	public void setFile(MultipartFile file) {
		this.File = file;
	}
	public List<MultipartFile> getFiles() {
		return Files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.Files = files;
	}
	@Override
	public String toString() {
		return "ImageDTO [ImageID=" + ImageID + ", ReferencesID=" + ReferencesID + ", IDType=" + IDType + ", FileName="
				+ FileName + ", FileURL=" + FileURL + ", File=" + File + ", Files=" + Files + "]";
	}
}
