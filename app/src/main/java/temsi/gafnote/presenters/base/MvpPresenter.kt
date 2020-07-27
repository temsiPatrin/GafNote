package temsi.gafnote.presenters.base


interface MvpPresenter<V : MvpView> {

    val isViewAttached: Boolean

    fun attachView(mvpView: V)

    fun detachView()
}
