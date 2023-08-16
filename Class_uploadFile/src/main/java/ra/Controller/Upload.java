package ra.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/upload" , "/"})
@PropertySource("classpath:upload.properties")
public class Upload {
    @Value("${upload}")
    private String uploadPath;

    @GetMapping("")
    public String getupload() {
        return "form";
    }

    @PostMapping("/image")
    public String handleUpload(Model model, @RequestParam("img") List<MultipartFile> image) {
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        List<String> stringList = new ArrayList<>();
        for (MultipartFile f : image) {
            String filename = f.getOriginalFilename();
            stringList.add(filename);
            try {
                FileCopyUtils.copy(f.getBytes(), new File(uploadPath + filename));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("image",stringList);
        return "home";
    }
}
