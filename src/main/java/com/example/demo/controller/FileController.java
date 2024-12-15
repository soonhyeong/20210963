// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;

// @Controller
// public class FileController {

//     @Value("${spring.servlet.multipart.location}") // properties에 등록된 업로드 폴더 경로 주입
//     private String uploadFolder;

//     @PostMapping("/upload-email")
//     public String uploadEmail(
//             @RequestParam("email") String email, 
//             @RequestParam("subject") String subject, 
//             @RequestParam("message") String message,
//             RedirectAttributes redirectAttributes) {
//         try {
//             // 업로드 경로 생성
//             Path uploadPath = Paths.get(uploadFolder).toAbsolutePath();
//             if (!Files.exists(uploadPath)) {
//                 Files.createDirectories(uploadPath);
//             }

//             // 이메일을 안전한 파일명으로 변환
//             String sanitizedEmail = email.replaceAll("[^a-zA-Z0-9]", "_");
//             Path filePath = uploadPath.resolve(sanitizedEmail + ".txt");

//             // 디버깅용 출력
//             System.out.println("File path: " + filePath);

//             // 파일 생성 및 내용 작성
//             try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
//                 writer.write("메일 제목: " + subject);
//                 writer.newLine();
//                 writer.write("요청 메시지:");
//                 writer.newLine();
//                 writer.write(message);
//             }

//             // 성공 메시지 설정
//             redirectAttributes.addFlashAttribute("message", "메일 내용이 성공적으로 업로드되었습니다!");

//         } catch (IOException e) {
//             // 에러 처리
//             e.printStackTrace();
//             redirectAttributes.addFlashAttribute("error", "파일 업로드 중 오류가 발생했습니다.");
//         }

//         // 완료 후 리다이렉트
//         return "redirect:/upload-form"; // 업로드 완료 후 이동할 페이지 경로
//     }
// }
