package in.SpringBot.LaptopApplication.Service;

//import in.SpringBoot.Filters.DTO.LaptopRequestDto;
//import in.SpringBoot.Filters.DTO.LaptopResopnseDto;
//import in.SpringBoot.Filters.Entity.Laptop;
//import in.SpringBoot.Filters.Repository.LaptopRepository;
import in.SpringBot.LaptopApplication.DTO.LaptopRequestDto;
import in.SpringBot.LaptopApplication.DTO.LaptopResopnseDto;
import in.SpringBot.LaptopApplication.Entity.Laptop;
import in.SpringBot.LaptopApplication.Repository.LaptopRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LaptopService {

    LaptopRepository laptopRepository;
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //create
    public LaptopResopnseDto createLaptop(@RequestBody LaptopRequestDto laptopreqDto){
        Laptop laptop = mapToEntity(laptopreqDto);


        LaptopResopnseDto laptopResopnseDto = mapToResponseDto(laptopRepository.save(laptop));
        return laptopResopnseDto;


    }
    // get
    public LaptopResopnseDto getLaptopById(Long id) {
        Laptop laptop = laptopRepository.findById(id)
                .orElseThrow();

        return mapToResponseDto(laptop);
    }
    //getAll
    public List<LaptopResopnseDto> getAllLaptops() {
        List<Laptop> laptops = laptopRepository.findAll();

        return laptops.stream()
                .map(this::mapToResponseDto)
                .toList();
    }
    //UpdateById
    public LaptopResopnseDto updateLaptop(LaptopRequestDto laptopreqDto, Long id) {

        Laptop existingLaptop = laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop Not Found"));

        Laptop updateLaptop = laptopRepository.save(existingLaptop);

        return mapToResponseDto(updateLaptop);
    }
    //deleteById
    public LaptopResopnseDto deleteLaptop(Long id) {
        Laptop deleted = laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop Not Found"));

        return mapToResponseDto(deleted);
    }

    public LaptopResopnseDto deleteLaptopSoftly(@PathVariable Long id) {
        Laptop deletedSoftly =  laptopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop Not Found"));

        deletedSoftly.setDeleted(true);

        return mapToResponseDto(deletedSoftly);
    }

    public Laptop mapToEntity(LaptopRequestDto laptopreqDto) {
        Laptop laptop = new Laptop();
        laptop.setBuyerEmail(laptopreqDto.getBuyerEmail());
        laptop.setBuyerName(laptopreqDto.getBuyerName());
        laptop.setModel(laptopreqDto.getModel());
        laptop.setPrice(laptopreqDto.getPrice());
        laptop.setBuyerMobile(laptopreqDto.getBuyerMobile());
        laptop.setDeleted(false);
        laptop.setManufacturer(laptopreqDto.getManufacturer());
        laptop.setSellerName(laptopreqDto.getSellerName());
        laptop.setManufactureDate(laptopreqDto.getManufactureDate());
        laptop.setPassword(laptopreqDto.getPassword());
        laptop.setBuyingat(LocalDateTime.now());
        laptop.setDelevered(laptopreqDto.getDelevered());

        return laptop;

    }

    public LaptopResopnseDto mapToResponseDto(Laptop laptop) {
        LaptopResopnseDto responseDto = new LaptopResopnseDto();
        responseDto.setId(laptop.getId());
        responseDto.setBuyerName(laptop.getBuyerName());
        responseDto.setModel(laptop.getModel());
        responseDto.setPrice(laptop.getPrice());
        responseDto.setSellerName(laptop.getSellerName());
        responseDto.setDelevered(laptop.getDelevered());
        responseDto.setManufacturer(laptop.getManufacturer());
        responseDto.setPrice(laptop.getPrice());
        responseDto.setManufactureDate(laptop.getManufactureDate());

        return responseDto;

    }

}
