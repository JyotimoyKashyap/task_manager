package TaskRepo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import Database.TaskDao;
import Database.TaskDatabase;
import Database.TaskEntity;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<TaskEntity>> allTask;

    public TaskRepository(Application application){
        TaskDatabase taskDatabase = TaskDatabase.getInstance(application);
        taskDao = taskDatabase.taskDao();
        allTask = taskDao.getAllTask();
    }

    public void insert(TaskEntity entity){

        new InsertTaskAsyncTask(taskDao).execute(entity);


    }

    public void update(TaskEntity entity){

        new UpdateTaskAsyncTask(taskDao).execute(entity);



    }

    public void delete(TaskEntity entity){
        new DeleteTaskAsyncTask(taskDao).equals(entity);


    }


    public LiveData<List<TaskEntity>> getAllTask() {
        return allTask;
    }

    private static class InsertTaskAsyncTask extends AsyncTask<TaskEntity, Void, Void >{

        private TaskDao taskDao;
        private InsertTaskAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(TaskEntity... taskEntities) {
            taskDao.insert(taskEntities[0]);
            return null;
        }
    }

    private static class UpdateTaskAsyncTask extends AsyncTask<TaskEntity, Void, Void >{

        private TaskDao taskDao;
        private UpdateTaskAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(TaskEntity... taskEntities) {
            taskDao.update(taskEntities[0]);
            return null;
        }
    }

    private static class DeleteTaskAsyncTask extends AsyncTask<TaskEntity, Void, Void >{

        private TaskDao taskDao;
        private DeleteTaskAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(TaskEntity... taskEntities) {
            taskDao.delete(taskEntities[0]);
            return null;
        }
    }
}
