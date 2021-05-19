package com.timetabling.demo.controller;

import com.timetabling.demo.dto.*;
import com.timetabling.demo.model.*;
import com.timetabling.demo.repositary.BatchRepo;
import com.timetabling.demo.repositary.ClassroomRepo;
import com.timetabling.demo.repositary.UserRepo;
import com.timetabling.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final BatchService batchService;

    @Autowired
    private final ModuleService moduleService;

    @Autowired
    private final TimetableService timetableService;

    @Autowired
    private final ClassRoomService classRoomService;

    @Autowired
    private final BatchRepo batchRepo;
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final ClassroomRepo classroomRepo;


    @Autowired
    public AdminController(UserService userService, BatchService batchService, ModuleService moduleService, TimetableService timetableService, ClassRoomService classRoomService, BatchRepo batchRepo, UserRepo userRepo, ClassroomRepo classroomRepo) {
        this.userService = userService;
        this.batchService = batchService;
        this.moduleService = moduleService;
        this.timetableService = timetableService;
        this.classRoomService = classRoomService;
        this.batchRepo = batchRepo;
        this.userRepo = userRepo;
        this.classroomRepo = classroomRepo;
    }

    //----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = "/viewStudents")
    public String viewAllStudents(Model m) {
        List<userDTO> allUsers = userService.getAllStudents();
        m.addAttribute("users", allUsers);
        return "viewStudents";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/viewLecturers")
    public String viewAllLecturers(Model m){
        List<userDTO> allLecturers= userService.getAllLecturers();
        m.addAttribute("Lecturers", allLecturers);
        return "viewLecturers";
    }
    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/viewAdminCancelClasses")
    public String viewScheduledClasses(Model m){
        List<Timetable> allTimetables= timetableService.getAllTimetables();
        m.addAttribute("timetables", allTimetables);
        return "adminCancelClasses";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping(path = "/viewRemoveBatch")
    public String viewAllBatches(Model m) {
        List<Batch> allBatches = batchService.getAllBatches();
        m.addAttribute("batches", allBatches);
        return "removeBatches";
    }

    //----------------------------------------------------------------------------------------------------------------
    @GetMapping("/viewRemoveModules")
    public String viewAllModules(Model m) {
        List<Module> allModules = moduleService.getAllModules();
        m.addAttribute("modules", allModules);
        return "removeModules";
    }

    @GetMapping("/viewClassRooms")
    public String viewAllClasses(Model m){
        List<ClassRoom> allClassRooms= classRoomService.getAllClassRooms();
        m.addAttribute("ClassRooms",allClassRooms);
        return "viewClassRooms";
    }
    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/viewAddUsers")
    public String RegisterUsers(Model m) {
        List <batchDTO> allBatches= batchService.getAllBatchesToList();
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("batchList", allBatches);
        m.addAttribute("AddUser", new userDTO());
        return "addUsers";
    }

    @PostMapping("/adminAddUsers")
    public String StudentRegistration(@ModelAttribute("AddUser") userDTO dto, Model m) {
        try{
            m.addAttribute("success","Student has been added to the system successfully!");
            userService.registerUsers(dto);
        }
        catch(Exception ex){
            m.addAttribute("error","Cannot add the Student at this moment.Try again later!");
        }

        return "redirect:/viewAdminHome";
    }

    @GetMapping("/viewAddLecturers")
    public String RegisterLecturers(Model m){
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("addLecturers", new userDTO());
        return "addLecturers";
    }

    @PostMapping("adminAddLecturers")
    public String LecturerRegistration(@ModelAttribute("addLecturers") userDTO dto, Model m){
        try{
            m.addAttribute("success","User has been added to the system successfully!");
            userService.registerUsers(dto);
        }
        catch (Exception ex){
            m.addAttribute("error", "Cannot add the user at this moment.Try again later!");
        }

        return "redirect:/viewAdminHome";
    }

    @PostMapping("/adminUpdateUsers")
    public String updateU(@ModelAttribute("upUser")User dto, Model a){
        try{
            a.addAttribute("success","User has been updated successfully!");
            userService.updateUserInfo(dto);
        }
        catch(Exception e){
            a.addAttribute("error","Cannot update the user at this time.Please try again!");
        }

        return "updateUser";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/viewCreateBatch")
    public String addBatches(Model m) {
        m.addAttribute("AddBatches", new batchDTO());
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        return "createBatch";
    }

    @PostMapping("/adminAddBatches")
    public String BatchRegister(@ModelAttribute("AddBatches") batchDTO dto, Model a) {
        try{
            a.addAttribute("success","New Batch has been added to the system successfully.");
            batchService.createBatch(dto);

        }
        catch (Exception ex){
            a.addAttribute("error","Can't Add the batch at this moment.Please try again later!");
        }

        return "createBatch";
    }

    @PostMapping("/adminUpdateBatches")
    public String updateB(@ModelAttribute("getBatch")batchDTO dto, Model a){
        try{
            a.addAttribute("success","Batch details has been updated successfully.");
            batchService.updateBatchInfo(dto);
        }
        catch(Exception e){
            a.addAttribute("error","Cannot Update the Batch at this moment.Please try again!");
        }

        return "/updateBatches";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/viewAddModules")
    public String addModules(Model m) {
        List <batchDTO> allBatches= batchService.getAllBatchesToList();
        m.addAttribute("batchList", allBatches);
        List<userDTO> allLecturers=userService.getAllLecturersToList();
        m.addAttribute("lecList",allLecturers);
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("AddModules", new moduleDTO());
        return "addModules";
    }

    @PostMapping("/adminAddModules")
    public String ModuleRegister(@ModelAttribute("AddModules") moduleDTO dto, Model m) {
        try{
            m.addAttribute("success", "Module has been added to system successfully !");
            moduleService.createModule(dto);
        }catch(Exception ex){
            m.addAttribute("error", "Cannot Add the Module at this moment.Please try again later!");
        }

        return "redirect:/viewAdminHome";
    }

    @PostMapping("/adminUpdateModules")
    public String updateM(@ModelAttribute("getModule")moduleDTO dto, Model m){
        try{
            moduleService.updateModuleInfo(dto);
            m.addAttribute("success", "Module details has been updated successfully !");
        }
        catch (Exception e){
            m.addAttribute("error", "Cannot Update the Module at this moment.Please try again later!");
        }

        return "updateModules";
    }

    @RequestMapping("/deleteModule/{moduleId}")
    public String deleteModules(@PathVariable(name = "moduleId") Module moduleId, Model m){
        try{
            m.addAttribute("success", "Module details has been deleted successfully !");
            moduleService.deleteModules(moduleId);
        }
        catch (Exception ex){
            m.addAttribute("error", "Module cannot delete at this time.Please try again later !");
        }

        return  "redirect:/viewAdminHome";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/viewClassScheduling")
    public String addTimeTable(Model m) {

        List <batchDTO> allBatches= batchService.getAllBatchesToList();
        m.addAttribute("batchList", allBatches);

        List<classRoomDTO> allClassRooms= classRoomService.getAllClassRoomsToList();
        m.addAttribute("classRoomList", allClassRooms);

        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("AddTimetable", new timetableDTO());
        return "classScheduling";
    }


    @PostMapping("/adminAddTimetable")
    public String scheduleTimetable(@ModelAttribute("AddTimetable") timetableDTO dto) {
        timetableService.createTimetable(dto);
        return "redirect:/viewAdminHome";
    }



    //----------------------------------------------------------------------------------------------------------------


    @GetMapping("/viewAddClassRoom")
    public String addClassRooms(Model m){
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("AddClasses", new classRoomDTO());
        return "addClassRoom";
    }

    @PostMapping("/adminAddClassRooms")
    public String addClasses(@ModelAttribute("AddClasses") classRoomDTO dto, Model m){
        try{
            m.addAttribute("success", "The New Class-Room has been added to system successfully!");
            classRoomService.addClassRoom(dto);
        }
        catch (Exception e){
            m.addAttribute("error", "Cannot Add the Class-Room to the System at this moment.Please try again later!");
        }

        return "addClassRoom";
    }

    @PostMapping("/adminUpdateClassRoom")
    public String updateClassRoom(@ModelAttribute("getClassRoom") classRoomDTO dto, Model m){
        try{
            m.addAttribute("success", "Class-Room details has been updated successfully!");
            classRoomService.updateClassRoom(dto);
        }
        catch (Exception e){
            m.addAttribute("error", "Cannot Update the Class-Room details at this moment! Please Try again.");
        }
        classRoomService.updateClassRoom(dto);
        return "/updateClassRoom";
    }

    @RequestMapping("/deleteClassRoom/{classRoomId}")
    public String deleteClass(@PathVariable( name = "classRoomId")ClassRoom classRoom, Model m){
        try{
            m.addAttribute("success","ClassRoom has been deleted Successfully!");
            classRoomService.deleteClassRoom(classRoom);
        }
        catch (Exception ex){
            m.addAttribute("error","Cannot delete the ClassRoom at this time. Please try again later!");
        }

        return "viewClassRooms";
    }

    //----------------------------------------------------------------------------------------------------------------

//    In the below functions what is happening is it take each and every object to a single page according to the selected item.

    @GetMapping("/getUser/{email}")
    public String getUser(Model m, @PathVariable(value = "email")String email){
        User u= userService.getUserByID(email);
        User user = new User();
        m.addAttribute("upUser", user);
        m.addAttribute("findUser", u);
        return "updateUser";
    }

    @GetMapping("/getBatch/{batchId}")
    public String getBatch(Model m, @PathVariable(value = "batchId")String batchId){
        Batch b= batchService.getBatchById(batchId);
        Batch batch= new Batch();
        m.addAttribute("getBatch",batch);
        m.addAttribute("findBatch",b);
        return "updateBatches";
    }

    @GetMapping("/getTimetable/{timetableId}")
    public String getTimetable(Model m, @PathVariable(value = "timetableId") Integer timetableId){
        Timetable t = timetableService.getTimetableById(timetableId);
        Timetable timetable= new Timetable();
        m.addAttribute("getTimetable", timetable);
        m.addAttribute("findTimetable",t);
        return "adminReScheduling";
    }

    @GetMapping("/getModule/{moduleId}")
    public String getModule(Model m,@PathVariable(value = "moduleId") String moduleId){
        Module mo= moduleService.getModuleById(moduleId);
        Module module= new Module();
        m.addAttribute("getModule",module);
        m.addAttribute("findModule",mo);
        return "updateModules";
    }

    @GetMapping("/getClassRoom/{classRoomId}")
    public String getClassRoom(Model m, @PathVariable(value = "classRoomId") String classRoomId){
        ClassRoom cr= classRoomService.getClassRoomById(classRoomId);
        ClassRoom classRoom= new ClassRoom();
        m.addAttribute("getClassRoom", classRoom);
        m.addAttribute("findClassRoom", cr);
        return "updateClassRoom";
    }

}



//    @GetMapping("/viewUpdateModules")
//    public String updateModuleDetails(Model m){
//        m.addAttribute("updateModule",new moduleDTO());
//        return "updateModules";
//    }
//
//    @PostMapping("/adminUpdateModules")
//    public String moduleUpdating(@ModelAttribute("updateModule") moduleDTO dto){
//        userService.updateModule(dto);
//        return "redirect:/viewAdminHome";
//    }


//    @PostMapping("/adminAddTimetable")
//    public String scheduleTimetable(HttpServletRequest req) {
//        String batch = req.getParameter("batch");
//        String moduleName = req.getParameter("moduleName");
//        String classRoom = req.getParameter("classRoom");
//        String user = req.getParameter("user");
//        String scheduledDate = req.getParameter("scheduledDate");
//        String startTime = req.getParameter("startTime");
//        String endTime = req.getParameter("endTime");
//
//        timetableDTO dto = new timetableDTO();
//
//        dto.setBatch(batchRepo.getOne(batch));
//        dto.setModuleName(moduleName);
//        dto.setClassRoom(classroomRepo.getOne(classRoom));
//        dto.setUser(userRepo.findUserByEmail(user));
//        dto.setScheduledDate(Date.valueOf(scheduledDate));
//        dto.setStartTime(LocalTime.parse(startTime));
//        dto.setEndTime(LocalTime.parse(endTime));
//        timetableService.createTimetable(dto);
//        return "redirect:/viewAdminHome";
//    }