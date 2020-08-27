package Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(TaskEntity entity);

    @Update
    void update(TaskEntity entity);

    @Delete
    void delete(TaskEntity entity);

    @Query("SELECT * FROM task_table ORDER BY priority DESC")
    LiveData<List<TaskEntity>> getAllTask();
}
