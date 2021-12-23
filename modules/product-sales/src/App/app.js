import React from "react";
import Menu from "../MyComponents/menu/Menu";
import {ClayIconSpriteContext} from '@clayui/icon';

function App() {
  const spritemap = `${Liferay.ThemeDisplay.getPathThemeImages()}/clay/icons.svg`

  return (
    <div>
      <ClayIconSpriteContext.Provider value={spritemap}>
        <Menu />
      </ClayIconSpriteContext.Provider>
    </div>
  );
}

export default App;
