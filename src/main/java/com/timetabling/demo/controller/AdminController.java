package com.timetabling.demo.controller;

import com.timetabling.demo.dto.*;
import com.timetabling.demo.exceptions.BatchIdExistException;
import com.timetabling.demo.model.*;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.repositary.BatchRepo;
import com.timetabling.demo.repositary.ClassroomRepo;
import com.timetabling.demo.repositary.UserRepo;
import com.timetabling.demo.service.*;
import com.timetabling.demo.validators.userValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

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
    private userValidator userValidator;

    private Logger logger;

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

    //=======================================  View Functions  =======================================================


    //-------------------  View All Students ---------------------

    @GetMapping(path = "/viewStudents")
    public String viewAllStudents(Model m) {
        List<userDTO> allUsers = userService.getAllStudents();
        m.addAttribute("users", allUsers);
        return "viewStudents";
    }

    @GetMapping("/searchUsers")
    public String searchUser(HttpServletRequest req, Model m) {
        String name = req.getParameter("searchByName");
        List<userDTO> userList = userService.searchUsers(name);
        m.addAttribute("users", userList);
        return "viewStudents";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping(path = "/viewLecturers")
    public String viewAllLecturers(Model m) {
        List<userDTO> allLecturers = userService.getAllLecturers();
        m.addAttribute("Lecturers", allLecturers);
        return "viewLecturers";
    }
    //----------------------------------------------------------------------------------------------------------------

    @GetMapping(path = "/viewAdminCancelClasses")
    public String viewScheduledClasses(Model m) {
        List<Timetable> allTimetables = timetableService.getAllTimetables();
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

    @GetMapping("/searchBatches")
    public String searchBatches(HttpServletRequest req, Model m) {
        String name = req.getParameter("searchByName");
        List<batchDTO> batches = batchService.searchBatches(name);
        m.addAttribute("batches", batches);
        return "removeBatches";
    }

    //----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = "/viewRemoveModules")
    public String viewAllModules(Model m) {
        List<Module> allModules = moduleService.getAllModules();
        m.addAttribute("modules", allModules);
        return "removeModules";
    }

    @GetMapping("/searchModules")
    public String searchModules(HttpServletRequest req, Model m) {
        String name = req.getParameter("searchByName");
        List<moduleDTO> modules = moduleService.searchModules(name);
        m.addAttribute("modules", modules);
        return "removeModules";
    }

    @GetMapping("/viewClassRooms")
    public String viewAllClasses(Model m) {
        List<ClassRoom> allClassRooms = classRoomService.getAllClassRooms();
        m.addAttribute("ClassRooms", allClassRooms);
        return "viewClassRooms";
    }
    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/getUser/{email}")
    public String getUser(Model m, @PathVariable(value = "email") String email) {
        User u = userService.getUserByID(email);
        User user = new User();
        m.addAttribute("upUser", user);
        m.addAttribute("findUser", u);
        return "updateUser";
    }

    @GetMapping("/viewAddUsers")
    public String RegisterUsers(Model m) {
        List<batchDTO> allBatches = batchService.getAllBatchesToList();
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("batchList", allBatches);
        m.addAttribute("AddUser", new userDTO());
        return "addUsers";
    }

    @PostMapping("/adminAddUsers")
    public String StudentRegistration(@ModelAttribute("AddUser") userDTO dto, Model m, RedirectAttributes redirectAttributes) {
        try {

            userService.registerUsers(dto);
            m.addAttribute("success", "Student has been added to the system successfully!");

        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }

        return "redirect:/viewAdminHome";
    }

    @GetMapping("/viewAddLecturers")
    public String RegisterLecturers(Model m) {
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("addLecturers", new userDTO());
        return "addLecturers";
    }

    @PostMapping("adminAddLecturers")
    public String LecturerRegistration(@ModelAttribute("addLecturers") userDTO dto, Model m, RedirectAttributes redirectAttributes) {
        try {

            userService.registerLecturers(dto);
            m.addAttribute("success", "User has been added to the system successfully!");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }

        return "redirect:/viewAdminHome";
    }


    @PostMapping("/adminUpdateUsers")
    public String updateU(@ModelAttribute("upUser") User dto, Model a) {
        try {
            userService.updateUserInfo(dto);
            a.addAttribute("success", "User has been updated successfully!");

        } catch (Exception e) {
            a.addAttribute("error", "Cannot update the user at this time.Please try again!");
        }

        return "updateUser";
    }

    @RequestMapping("/deleteLec/{email}")
    public String removeLecturer(@PathVariable(name = "email") User email, Model m) {
        try {
            userService.removeUser(email);
            m.addAttribute("success", "Lecturer has been removed from the system successfully!");
        } catch (Exception ex) {
            m.addAttribute("error", "Cannot remove the Lecturer at this time because this Lecturer is teaching some modules.Please try again later!");
        }
        return "viewLecturers";
    }

    @RequestMapping("/deleteStudent/{email}")
    public String removeStudent(@PathVariable(name = "email") User email, Model m) {
        try {
            userService.removeUser(email);
            m.addAttribute("success", "User has been removed from the system successfully!");
        } catch (Exception ex) {
            m.addAttribute("error", "Cannot remove the user at this time.Please try again later!");
        }
        return "viewStudents";
    }

    //----------------------------------------------------------------------------------------------------------------


    @GetMapping("/getBatch/{batchId}")
    public String getBatch(Model m, @PathVariable(value = "batchId") String batchId) {
        Batch b = batchService.getBatchById(batchId);
        Batch batch = new Batch();
        m.addAttribute("getBatch", batch);
        m.addAttribute("findBatch", b);
        return "updateBatches";
    }


    @GetMapping("/viewCreateBatch")
    public String addBatches(Model m) {
        m.addAttribute("AddBatches", new batchDTO());
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        return "createBatch";
    }


    @PostMapping("/adminAddBatches")
    public String BatchRegister(@ModelAttribute("AddBatches") batchDTO dto, Model a) {
        try {
            batchService.createBatch(dto);
            a.addAttribute("success", "New Batch has been added to the system successfully.");

        } catch (Exception ex) {
            a.addAttribute("error",  ex.getMessage());
        }

        return "createBatch";
    }



    @PostMapping("/adminUpdateBatches")
    public String updateB(@ModelAttribute("getBatch") batchDTO dto, Model a) {
        try {
            batchService.updateBatchInfo(dto);
            a.addAttribute("success", "Batch details has been updated successfully.");

        } catch (Exception e) {
            a.addAttribute("error", "Cannot Update the Batch at this moment.Please try again!");
        }

        return "/updateBatches";
    }

    @RequestMapping("/deleteBatch/{batchId}")
    public String removeBatch(@PathVariable(name = "batchId") Batch batchId, Model m) {
        try {
            batchService.deleteBatch(batchId);
            m.addAttribute("success", "Batch has been deleted successfully!");
        } catch (Exception ex) {
            m.addAttribute("error", "Cannot remove the batch at this time.Please try again later!");
        }
        return "removeBatches";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/getModule/{moduleId}")
    public String getModule(Model m, @PathVariable(value = "moduleId") String moduleId) {
        Module mo = moduleService.getModuleById(moduleId);
        Module module = new Module();
        m.addAttribute("getModule", module);
        m.addAttribute("findModule", mo);
        return "updateModules";
    }


    @GetMapping("/viewAddModules")
    public String addModules(Model m) {
        List<batchDTO> allBatches = batchService.getAllBatchesToList();
        m.addAttribute("batchList", allBatches);
        List<userDTO> allLecturers = userService.getAllLecturersToList();
        m.addAttribute("lecList", allLecturers);
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("AddModules", new moduleDTO());
        return "addModules";
    }

    @PostMapping("/adminAddModules")
    public String ModuleRegister(@ModelAttribute("AddModules") moduleDTO dto, Model m) {
        try {
            moduleService.createModule(dto);
            m.addAttribute("success", "Module has been added to system successfully !");

        } catch (Exception ex) {
            m.addAttribute("error",  ex.getMessage());
        }

        return "addModules";
    }

    @PostMapping("/adminUpdateModules")
    public String updateM(@ModelAttribute("getModule") moduleDTO dto, Model m) {
        try {
            moduleService.updateModuleInfo(dto);
            m.addAttribute("success", "Module details has been updated successfully !");
        } catch (Exception e) {
            m.addAttribute("error", "Cannot Update the Module at this moment.Please try again later!");
        }

        return "updateModules";
    }

    @RequestMapping("/deleteModule/{moduleId}")
    public String deleteModules(@PathVariable(name = "moduleId") Module moduleId, Model m) {
        try {
            moduleService.deleteModules(moduleId);
            m.addAttribute("success", "Module has been deleted successfully !");

        } catch (Exception ex) {
            m.addAttribute("error", "Module cannot delete at this time.Please try again later !");
        }

        return "removeModules";
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/getTimetable/{timetableId}")
    public String getTimetable(Model m, @PathVariable(value = "timetableId") Integer timetableId) {
        timetableDTO t = timetableService.getTimetableById(timetableId);
        Timetable timetable = new Timetable();
        m.addAttribute("getTimetable", timetable);
        m.addAttribute("findTimetable", t);
        return "adminReScheduling";
    }

    @GetMapping("/getModuleToTimetable/{moduleId}")
    public String getModuleToTimetable(@PathVariable(value = "moduleId") String moduleId, Model m) {
        Module mo = moduleService.getModuleById(moduleId);
        m.addAttribute("findModule", mo);

        timetableDTO theDTO = new timetableDTO();
        theDTO.setBatches(mo.getBatches());

        m.addAttribute("addTimetable", theDTO);

        List<classRoomDTO> allClassRooms = classRoomService.getAllClassRoomsToList();
        m.addAttribute("classRoomList", allClassRooms);

        return "scheduleClass";
    }


    @PostMapping("/adminAddTimetable")
    public String scheduleTimetable(@ModelAttribute("addTimetable") timetableDTO dto, Model m) {
        try {
            timetableService.createTimetable(dto);
            m.addAttribute("success", "Timetable has been scheduled successfully !");
        } catch (Exception ex) {
            ex.printStackTrace();
            m.addAttribute("error", ex.getMessage());

        }

        return "scheduleClass";
    }


    @PostMapping("/classRescheduling")
    public String reScheduleClasses(@ModelAttribute("findTimetable") timetableDTO dto, Model m) {
        try {
            timetableService.reScheduleTimetable(dto);
            m.addAttribute("success", "Module has been Re-Scheduled successfully!");
        } catch (Exception ex) {
            m.addAttribute("error", "Cannot Re-Schedule the class at this time. Please try again later.");
        }
        return "adminReScheduling";
    }


    @RequestMapping("/cancelTimetable/{timetableId}")
    public String cancelScheduledClasses(@PathVariable(name = "timetableId") Timetable timetableId, Model m) {
        try {
            timetableService.cancelScheduledClass(timetableId);
            m.addAttribute("success", "Selected timetable has been cancelled successfully!");
        } catch (Exception ex) {
            m.addAttribute("error", "Selected Timetable cannot delete at this time. Please try again later.");
        }
        return "adminCancelClasses";
    }

    //----------------------------------------------------------------------------------------------------------------


    @GetMapping("/getClassRoom/{classRoomId}")
    public String getClassRoom(Model m, @PathVariable(value = "classRoomId") String classRoomId) {
        ClassRoom cr = classRoomService.getClassRoomById(classRoomId);
        ClassRoom classRoom = new ClassRoom();
        m.addAttribute("getClassRoom", classRoom);
        m.addAttribute("findClassRoom", cr);
        return "updateClassRoom";
    }


    @GetMapping("/viewAddClassRoom")
    public String addClassRooms(Model m) {
        m.addAttribute("successMessage");
        m.addAttribute("errorMessage");
        m.addAttribute("AddClasses", new classRoomDTO());
        return "addClassRoom";
    }

    @PostMapping("/adminAddClassRooms")
    public String addClasses(@ModelAttribute("AddClasses") classRoomDTO dto, Model m) {
        try {
            classRoomService.addClassRoom(dto);
            m.addAttribute("success", "The New Class-Room has been added to system successfully!");

        } catch (Exception e) {
            m.addAttribute("error",  e.getMessage());
        }

        return "addClassRoom";
    }

    @PostMapping("/adminUpdateClassRoom")
    public String updateClassRoom(@ModelAttribute("getClassRoom") classRoomDTO dto, Model m) {
        try {
            classRoomService.updateClassRoom(dto);
            m.addAttribute("success", "Class-Room details has been updated successfully!");

        } catch (Exception e) {
            m.addAttribute("error", "Cannot Update the Class-Room details at this moment! Please Try again.");
        }
        return "/updateClassRoom";
    }


    @RequestMapping("/deleteClassRoom/{classRoomId}")
    public String deleteClass(@PathVariable(name = "classRoomId") ClassRoom classRoom, Model m) {
        try {
            classRoomService.deleteClassRoom(classRoom);
            m.addAttribute("success", "ClassRoom has been deleted Successfully!");

        } catch (Exception ex) {
            m.addAttribute("error", "Cannot delete the ClassRoom at this time. Please try again later!");
        }

        return "viewClassRooms";
    }

    //-----------------------------------------------     END     ----------------------------------------------------

}

