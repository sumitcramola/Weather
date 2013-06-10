package com.expedia.weather.constant;

/**
 * The Enum ViewName provides the name of all the UI view where our modal has to be redirected.
 */
public enum ViewName {

    /** The default. */
    WEATHER("weather")
;

    /** The view name. */
    private String viewName;

    /**
     * Instantiates a new view names.
     * 
     * @param viewName
     *            the view name
     */
    private ViewName(final String viewName) {
        this.viewName = viewName;
    }

    /**
     * Gets the view name.
     * 
     * @return the view name
     */
    public String getViewName() {
        return viewName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return viewName;
    }
}
