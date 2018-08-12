package a1door.woofer.Logic.Interfaces;

public interface onMenuButtonClickListener {
    void registerMenuBtnsClickShowListeners(MenuBtnsClickListener listener);
    void deletesMenuBtnsClickShowListeners(MenuBtnsClickListener listener);

    interface MenuBtnsClickListener{
        void onMenuBtnsClick(int whereToGo);
    }
}
