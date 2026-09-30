package com.example.schoolmanagment.Service;

import com.example.schoolmanagment.ApiResponse.ApiException;
import com.example.schoolmanagment.Model.Teacher;
import com.example.schoolmanagment.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> get(){
        List<Teacher> teachers = teacherRepository.findAll();

        if (teachers.isEmpty()){
            throw new ApiException("The list is empty");
        }

        return teachers;
    }

    public void add(Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(teacher.getId());

        if (oldTeacher != null){
            throw new ApiException("Teacher already exist");
        }

        teacherRepository.save(teacher);
    }

    public void update(Integer id,Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if (oldTeacher == null){
            throw new ApiException("Teacher not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setAddress(teacher.getAddress());

        teacherRepository.save(oldTeacher);
    }

    public void delete(Integer id){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if (oldTeacher == null){
            throw new ApiException("Teacher not found");
        }

        teacherRepository.delete(oldTeacher);
    }

    public Teacher getByTeacherId(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }
}
