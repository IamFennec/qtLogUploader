package qtlog.DataModel;

import qtlog.UIController.IModelObserver;
import qtlog.shared.LogDTO;

public interface IDataModel {
    public LogDTO getLatestLog();
    public void registerObs(IModelObserver observer);
}
