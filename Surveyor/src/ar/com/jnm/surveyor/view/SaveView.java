package ar.com.jnm.surveyor.view;

import ar.com.jnm.surveyor.Application;

public class SaveView implements View {

  private Application application;

  public SaveView(Application application) {
    setApplication(application);
  }

  @Override
  public void show() {
    try {
      getApplication().save();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  @Override
  public String getDescription() {
    return "Save database";
  }

  private Application getApplication() {
    return application;
  }

  private void setApplication(Application application) {
    this.application = application;
  }

}
