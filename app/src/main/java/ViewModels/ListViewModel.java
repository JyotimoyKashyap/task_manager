package ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import Database.TaskEntity;
import TaskRepo.TaskRepository;

public class ListViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<TaskEntity>> allTask;


    public ListViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        allTask = repository.getAllTask();
    }

    public void insert(TaskEntity entity){
        repository.insert(entity);
    }

    public void update(TaskEntity entity){
        repository.update(entity);
    }

    public void delete(TaskEntity entity){
        repository.delete(entity);
    }

    public LiveData<List<TaskEntity>> getAllTask() {
        return allTask;
    }
}
