package qtlog.UIController;

import qtlog.DataModel.IDataModel;
import qtlog.UserInterface.IUserInterface;
import qtlog.shared.LogDTO;

public class UIController implements IModelObserver{
    private IDataModel dataModel;
    private IUserInterface ui;

    public UIController(IDataModel dataModel, IUserInterface userInterface){
        this.ui = userInterface;
        this.dataModel = dataModel;
        this.dataModel.registerObs(this);
    }

    @Override
    public void updateModelObserver() {
        LogDTO tempLog = this.dataModel.getLatestLog();
        this.ui.updateUI(tempLog);
    }
    
}
