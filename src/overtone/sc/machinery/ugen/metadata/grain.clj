(ns overtone.sc.machinery.ugen.metadata.grain
  (:use [overtone.sc.machinery.ugen common check]))

(def specs
  [{:name "GrainSin"
    :args [{:name "num-channels"
            :mode :num-outs
            :default 1
            :doc "the number of channels to output. If 1, mono is
                  returned and pan is ignored." }

           {:name "trigger"
            :default 0
            :doc "a kr or ar trigger to start a new grain. If ar, grains
                  after the start of the synth are sample accurate." }

           {:name "dur"
            :default 1
            :doc "size of the grain."}

           {:name "freq"
            :default 440.0
            :doc "the frequency of the grain's oscillator"}

           {:name "pan"
            :default 0
            :doc "Determines where to pan the output. If num-channels =
                  1, no panning is done; if num-channels = 2, panning is
                  similar to Pan2; if numChannels > 2, pannins is the
                  same as PanAz." }

           {:name "envbufnum"
            :default -1
            :doc "the buffer number containing a singal to use for the
                  grain envelope. -1 uses a built-in Hanning envelope."}

           {:name "max-grains"
            :default 512
            :doc " the maximum number of overlapping grains that can be
                   used at a given time. This value is set at the UGens
                   init time and can't be modified. This can be set
                   lower for more efficient use of memory." }]
    :rates #{:ar}
    :doc "Granular synthesis with sine tones"}

   {:name "GrainFM"
    :args [{:name "num-channels"
            :default 1
            :mode :num-outs
            :doc "the number of channels to output. If 1, mono is
                  returned and pan is ignored."}

           {:name "trigger"
            :default 0
            :doc "a kr or ar trigger to start a new grain. If ar, grains
                  after the start of the synth are sample accurate." }

           {:name "dur"
            :default 1
            :doc "size of the grain."}

           {:name "car-freq"
            :default 440.0
            :doc "the frequency of the FM grain's carrier oscillator"}

           {:name "mod-freq"
            :default 440.0
            :doc "the frequency of the FM grain's modulating oscillator"}

           {:name "index"
            :default 1
            :doc "the FM index"}

           {:name "pan"
            :default 0
            :doc "Determines where to pan the output. If num-channels =
                  1, no panning is done; if num-channels = 2, panning is
                  similar to Pan2; if numChannels > 2, pannins is the
                  same as PanAz." }

           {:name "envbufnum"
            :default -1
            :doc "the buffer number containing a singal to use for the
                  grain envelope. -1 uses a built-in Hanning envelope."}

           {:name "max-grains"
            :default 512
            :doc "the maximum number of overlapping grains that can be
                  used at a given time. This value is set at the UGens
                  init time and can't be modified. This can be set lower
                  for more efficient use of memory." }]
    :rates #{:ar}
    :doc "Granular synthesis with frequency modulated sine tones"}

   {:name "GrainBuf"
    :args [{:name "num-channels"
            :mode :num-outs
            :default 1
            :doc "the number of channels to output. If 1, mono is
                  returned and pan is ignored." }

           {:name "trigger"
            :default 0
            :doc "a kr or ar trigger to start a new grain. If ar, grains
                  after the start of the synth are sample accurate." }

           {:name "dur"
            :default 1
            :doc "size of the grain (in seconds)."}

           {:name "sndbuf"
            :default :none
            :doc "the buffer holding a mono audio signal. If using multi-channel
                  files, use Buffer.readChannel."}

           {:name "rate"
            :default 1
            :doc "the playback rate of the sampled sound" }

           {:name "pos"
            :default 1
            :doc "the playback position for the grain to start with (0 is
                  beginning, 1 is end of file)" }

           {:name "interp"
            :default 2
            :doc "the interpolation method used for pitchshifting grains:
                     1 = no interpolation
                     2 = linear
                     4 = cubic interpolation (more computationally intensive)" }

           {:name "pan"
            :default 0
            :doc "Determines where to pan the output. If num-channels =
                  1, no panning is done; if num-channels = 2, panning is
                  similar to Pan2; if num-channels > 2, pannins is the
                  same as PanAz." }

           {:name "envbufnum"
            :default -1
            :doc "the buffer number containing a singal to use for the
                  grain envelope. -1 uses a built-in Hanning envelope."                  }

           {:name "max-grains"
            :default 512
            :doc "the maximum number of overlapping grains that can be
                  used at a given time. This value is set at the UGens
                  init time and can't be modified. This can be set lower
                  for more efficient use of memory." }]
    :rates #{:ar}
    :doc "Granular synthesis with sound stored in a buffer"}

   {:name "GrainIn"
    :args [{:name "num-channels"
            :mode :num-outs
            :default 1
            :doc "the number of channels to output. If 1, mono is
                  returned and pan is ignored." }

           {:name "trigger"
            :default 0
            :doc "a kr or ar trigger to start a new grain. If ar, grains
                  after the start of the synth are sample accurate." }

           {:name "dur"
            :default 1
            :doc "size of the grain."}

           {:name "in"
            :default :none
            :doc "the input to granulate"}

           {:name "pan"
            :default 0
            :doc "Determines where to pan the output. If num-channels =
                  1, no panning is done; if num-channels = 2, panning is
                  similar to Pan2; if num-channels > 2, pannins is the
                  same as PanAz." }

           {:name "envbufnum"
            :default -1
            :doc "the buffer number containing a singal to use for the
                  grain envelope. -1 uses a built-in Hanning envelope."                  }

           {:name "max-grains"
            :default 512
            :doc "the maximum number of overlapping grains that can be
                  used at a given time. This value is set at the UGens
                  init time and can't be modified. This can be set lower
                  for more efficient use of memory." }]
    :rates #{:ar}
    :check (nth-input-stream? 2)
    :doc "Granulate an input signal"}


   {:name "Warp1"
    :args [{:name "num-channels"
            :mode :num-outs
            :default 1
            :doc "the number of channels in the soundfile used in
                  bufnum." }

           {:name "bufnum"
            :default 0
            :doc "the buffer number of a mono soundfile."}

           {:name "pointer"
            :default 0
            :doc "the position in the buffer.  The value should be
                  between 0 and 1, with 0 being the begining of the
                  buffer, and 1 the end." }

           {:name "freq-scale"
            :default 1
            :doc "the amount of frequency shift. 1.0 is normal, 0.5 is
                  one octave down, 2.0 is one octave up. Negative values
                  play the soundfile backwards." }

           {:name "window-size"
            :default 0.1
            :doc "the size of each grain window."}

           {:name "envbufnum"
            :default -1
            :doc "the buffer number containing a singal to use for the
                  grain envelope. -1 uses a built-in Hanning envelope." }

           {:name "overlaps"
            :default 8
            :doc "the number of overlaping windows."}

           {:name "window-rand-ratio"
            :default 0.0
            :doc "the amount of randomness to the windowing function.
                  Must be between 0 (no randomness) to 1.0 (probably to
                  random actually)"}

           {:name "interp"
            :default 1
            :doc "the interpolation method used for pitchshifting
                  grains. 1 = no interpolation. 2 = linear. 4 = cubic
                  interpolation (more computationally intensive)." }]
    :rates #{:ar}
    :doc "A granular time stretcher and pitchshifter.

          Inspired by Chad Kirby's SuperCollider2 Warp1 class, which was
          inspired by Richard Karpen's sndwarp for CSound."}])
