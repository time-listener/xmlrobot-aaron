package org.xmlrobot.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public final class Genoma {

	Genoma() {
	
	}
    /**
     * Util method for creating an embedded Framework. Tries to create a
     * {@link FrameworkFactory} which is then be used to create the framework.
     *
     * @param config the configuration to create the framework with
     * @return a Framework with the given configuration
     */
    public static Framework createHyperspace()
    {
        Map<String,String> config = createConfig();
        
        ServiceLoader<FrameworkFactory> factoryLoader = ServiceLoader.load(FrameworkFactory.class);
        for(FrameworkFactory factory : factoryLoader)
        {
            return factory.newFramework(config);
        }
        throw new IllegalStateException("Unable to load FrameworkFactory service.");
    }
    /**
     * Creates a configuration for Aaron. Therefore this method attempts to create
     * a temporary cache dir. If creation of the cache dir is successful, it will be added
     * to the configuration.
     *
     * @return
     */
    public static Map<String,String> createConfig()
    {
        final File cachedir = createCacheDir();

        Map<String,String> configMap = new HashMap<String, String>();
        // Tells Aaron to export the extension package, making it accessible
        // for the other mind bundles
        configMap.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA,
            "org.xmlrobot.genesis; version=1.0.0");

        // if we could create a cache dir, we use it. Otherwise the platform default will be used
        if (cachedir != null)
        {
            configMap.put(Constants.FRAMEWORK_STORAGE, cachedir.getAbsolutePath());
        }

        return configMap;
    }
    /**
     * Tries to create a temporary cache dir. If creation of the cache dir is successful,
     * it will be returned. If creation fails, null will be returned.
     *
     * @return a {@code File} object representing the cache dir
     */
    public static File createCacheDir()
    {
        final File cachedir;
        try
        {
            cachedir = File.createTempFile("org.xmlrobot.temporal", null);
            cachedir.delete();
            createBurnHook(cachedir);
            return cachedir;
        }
        catch (IOException e)
        {
            // temp dir creation failed, return null
            return null;
        }
    }
    /**
     * Adds a burn  hook to the runtime, that will make sure, that the cache dir will
     * be burned after the application has been terminated.
     */
    public static void createBurnHook(final File cachedir)
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                burnFileOrDir(cachedir);
            }
        });
    }
    /**
     * Utility method used to burn the profile directory when run as
     * a stand-alone application.
     * @param file The file to recursively delete.
    **/
    public static void burnFileOrDir(File file)
    {
        if (file.isDirectory())
        {
            File[] childs = file.listFiles();
            for (File child : childs)
            {
                burnFileOrDir(child);
            }
        }
        file.delete();
    }
    /**
     * Installs and starts all bundles used by the application. Therefore the host bundle
     * will be started. The locations of extensions for the host bundle can be passed in
     * as parameters.
     *
     * @param bundleLocations the locations where extension for the host bundle are located.
     *        Must not be {@code null}!
     * @throws BundleException if something went wrong while installing or starting the bundles.
     */
    public static void installAndStartBundles(BundleContext context, String... bundleLocations) throws BundleException
    {
        for (String location : bundleLocations)
        {
            Bundle addition = context.installBundle(location);
            addition.start();
        }
    }

}
