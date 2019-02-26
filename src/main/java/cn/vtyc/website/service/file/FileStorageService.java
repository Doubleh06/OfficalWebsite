package cn.vtyc.website.service.file;

import cn.vtyc.website.core.BusinessException;
import cn.vtyc.website.core.ErrorCode;
import cn.vtyc.website.property.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;


    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new BusinessException(ErrorCode.CANNOT_CREAT_UPLOADFILE );
        }
    }

    public String storeFile(MultipartFile file,String path) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new BusinessException(ErrorCode.FILENAME_ERROR,"文件名有误--"+ fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get(path,fileName);//this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new BusinessException( ErrorCode.FILE_UPLOAD_FAIL,"文件上传失败，请重试--"+fileName);
        }
    }

    public Resource loadFileAsResource(String fileName,String path) {
        try {
            Path filePath = FileSystems.getDefault().getPath(path+fileName);//this.fileStorageLocation.resolve(fileName).normalize();
//            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new BusinessException(ErrorCode.FILE_NOT_FOUND,("文件未找到--")+fileName);
            }
        } catch (MalformedURLException ex) {
            throw new BusinessException(ErrorCode.FILE_NOT_FOUND,("文件未找到--")+fileName);
        }
    }
}
