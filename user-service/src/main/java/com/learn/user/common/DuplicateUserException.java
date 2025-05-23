package com.learn.user.common;

public class DuplicateUserException extends Exception {

  private static final long serialVersionUID = -8890080495441147845L;

  private String message;
  private Object[] args;

  public DuplicateUserException(String name) {
    this.message = String.format("There is already an user with the name - %s", name);
  }

  public DuplicateUserException(Object[] args) {
    this.args = args;
  }

  public DuplicateUserException(String message, Object[] args) {
    this.message = message;
    this.args = args;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the args
   */
  public Object[] getArgs() {
    return args;
  }

  /**
   * @param args the args to set
   */
  public void setArgs(Object[] args) {
    this.args = args;
  }
}
