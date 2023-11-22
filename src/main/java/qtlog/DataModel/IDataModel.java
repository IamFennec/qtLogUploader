package qtlog.DataModel;

import qtlog.DPSReportController.DpsReportDTO;
import qtlog.UIController.IModelObserver;

public interface IDataModel {
    public DpsReportDTO getLatestLog();

    public void registerObs(IModelObserver observer);
}
