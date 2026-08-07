package in.SpringBot.LaptopApplication.Controller;

//import in.SpringBoot.Filters.DTO.LaptopRequestDto;
//import in.SpringBoot.Filters.DTO.LaptopResopnseDto;
//import in.SpringBoot.Filters.Service.LaptopService;
import in.SpringBot.LaptopApplication.DTO.LaptopRequestDto;
import in.SpringBot.LaptopApplication.DTO.LaptopResopnseDto;
import in.SpringBot.LaptopApplication.Service.LaptopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    LaptopService laptopService;
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public ResponseEntity<LaptopResopnseDto> createLaptop(@RequestBody LaptopRequestDto laptopRequestDto) {

        return ResponseEntity.ok(laptopService.createLaptop(laptopRequestDto));

    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopResopnseDto> getLaptopById(@PathVariable Long id) {

        return ResponseEntity.ok(laptopService.getLaptopById(id));
    }

    @GetMapping
    public ResponseEntity<List<LaptopResopnseDto>> getAllLaptops() {
        return ResponseEntity.ok(laptopService.getAllLaptops());
    }
    @PutMapping("/{id}")
    public ResponseEntity<LaptopResopnseDto> updateLaptop(@RequestBody LaptopRequestDto laptopRequestDto, @PathVariable Long id) {
        return ResponseEntity.ok(laptopService.updateLaptop(laptopRequestDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LaptopResopnseDto> deleteLaptop(@PathVariable Long id) {
        return ResponseEntity.ok(laptopService.deleteLaptop(id));
    }

    @PatchMapping("/delete_soft/{id}")
    public ResponseEntity<LaptopResopnseDto> deleteLaptopSoftly(@PathVariable Long id) {

        return ResponseEntity.ok(laptopService.deleteLaptopSoftly(id));
    }
}
