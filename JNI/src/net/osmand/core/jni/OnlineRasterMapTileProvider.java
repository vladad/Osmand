/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.3
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package net.osmand.core.jni;

public class OnlineRasterMapTileProvider extends IMapRasterBitmapTileProvider {
  private long swigCPtr;
  private boolean swigCMemOwnDerived;

  protected OnlineRasterMapTileProvider(long cPtr, boolean cMemoryOwn) {
    super(OsmAndCoreJNI.OnlineRasterMapTileProvider_SWIGSmartPtrUpcast(cPtr), true);
    swigCMemOwnDerived = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(OnlineRasterMapTileProvider obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwnDerived) {
        swigCMemOwnDerived = false;
        OsmAndCoreJNI.delete_OnlineRasterMapTileProvider(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public OnlineRasterMapTileProvider(String name, String urlPattern, ZoomLevel minZoom, ZoomLevel maxZoom, long maxConcurrentDownloads, long providerTileSize, AlphaChannelData alphaChannelData) {
    this(OsmAndCoreJNI.new_OnlineRasterMapTileProvider__SWIG_0(name, urlPattern, minZoom.swigValue(), maxZoom.swigValue(), maxConcurrentDownloads, providerTileSize, alphaChannelData.swigValue()), true);
  }

  public OnlineRasterMapTileProvider(String name, String urlPattern, ZoomLevel minZoom, ZoomLevel maxZoom, long maxConcurrentDownloads, long providerTileSize) {
    this(OsmAndCoreJNI.new_OnlineRasterMapTileProvider__SWIG_1(name, urlPattern, minZoom.swigValue(), maxZoom.swigValue(), maxConcurrentDownloads, providerTileSize), true);
  }

  public OnlineRasterMapTileProvider(String name, String urlPattern, ZoomLevel minZoom, ZoomLevel maxZoom, long maxConcurrentDownloads) {
    this(OsmAndCoreJNI.new_OnlineRasterMapTileProvider__SWIG_2(name, urlPattern, minZoom.swigValue(), maxZoom.swigValue(), maxConcurrentDownloads), true);
  }

  public OnlineRasterMapTileProvider(String name, String urlPattern, ZoomLevel minZoom, ZoomLevel maxZoom) {
    this(OsmAndCoreJNI.new_OnlineRasterMapTileProvider__SWIG_3(name, urlPattern, minZoom.swigValue(), maxZoom.swigValue()), true);
  }

  public OnlineRasterMapTileProvider(String name, String urlPattern, ZoomLevel minZoom) {
    this(OsmAndCoreJNI.new_OnlineRasterMapTileProvider__SWIG_4(name, urlPattern, minZoom.swigValue()), true);
  }

  public OnlineRasterMapTileProvider(String name, String urlPattern) {
    this(OsmAndCoreJNI.new_OnlineRasterMapTileProvider__SWIG_5(name, urlPattern), true);
  }

  public String getName() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_name_get(swigCPtr, this);
  }

  public String getPathSuffix() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_pathSuffix_get(swigCPtr, this);
  }

  public String getUrlPattern() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_urlPattern_get(swigCPtr, this);
  }

  public long getMaxConcurrentDownloads() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_maxConcurrentDownloads_get(swigCPtr, this);
  }

  public long getProviderTileSize() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_providerTileSize_get(swigCPtr, this);
  }

  public AlphaChannelData getAlphaChannelData() {
    return AlphaChannelData.swigToEnum(OsmAndCoreJNI.OnlineRasterMapTileProvider_alphaChannelData_get(swigCPtr, this));
  }

  public void setLocalCachePath(SWIGTYPE_p_QDir localCachePath, boolean appendPathSuffix) {
    OsmAndCoreJNI.OnlineRasterMapTileProvider_setLocalCachePath__SWIG_0(swigCPtr, this, SWIGTYPE_p_QDir.getCPtr(localCachePath), appendPathSuffix);
  }

  public void setLocalCachePath(SWIGTYPE_p_QDir localCachePath) {
    OsmAndCoreJNI.OnlineRasterMapTileProvider_setLocalCachePath__SWIG_1(swigCPtr, this, SWIGTYPE_p_QDir.getCPtr(localCachePath));
  }

  public SWIGTYPE_p_QDir getLocalCachePath() {
    return new SWIGTYPE_p_QDir(OsmAndCoreJNI.OnlineRasterMapTileProvider_localCachePath_get(swigCPtr, this), false);
  }

  public void setNetworkAccessPermission(boolean allowed) {
    OsmAndCoreJNI.OnlineRasterMapTileProvider_setNetworkAccessPermission(swigCPtr, this, allowed);
  }

  public boolean getNetworkAccessAllowed() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_networkAccessAllowed_get(swigCPtr, this);
  }

  public float getTileDensityFactor() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_getTileDensityFactor(swigCPtr, this);
  }

  public long getTileSize() {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_getTileSize(swigCPtr, this);
  }

  public boolean obtainData(TileId tileId, ZoomLevel zoom, MapTiledData outTiledData, SWIGTYPE_p_OsmAnd__IQueryController queryController) {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_obtainData__SWIG_0(swigCPtr, this, TileId.getCPtr(tileId), tileId, zoom.swigValue(), MapTiledData.getCPtr(outTiledData), outTiledData, SWIGTYPE_p_OsmAnd__IQueryController.getCPtr(queryController));
  }

  public boolean obtainData(TileId tileId, ZoomLevel zoom, MapTiledData outTiledData) {
    return OsmAndCoreJNI.OnlineRasterMapTileProvider_obtainData__SWIG_1(swigCPtr, this, TileId.getCPtr(tileId), tileId, zoom.swigValue(), MapTiledData.getCPtr(outTiledData), outTiledData);
  }

  public ZoomLevel getMinZoom() {
    return ZoomLevel.swigToEnum(OsmAndCoreJNI.OnlineRasterMapTileProvider_getMinZoom(swigCPtr, this));
  }

  public ZoomLevel getMaxZoom() {
    return ZoomLevel.swigToEnum(OsmAndCoreJNI.OnlineRasterMapTileProvider_getMaxZoom(swigCPtr, this));
  }

}