import React from "react";
import ClayAlert from "@clayui/alert";

export function Alert({
  displayType,
  title,
  message
}) {

  return (
    <ClayAlert.ToastContainer>
      <ClayAlert
        displayType={displayType}
        title={title}
        >{message}
      </ClayAlert>
    </ClayAlert.ToastContainer>
  )
}